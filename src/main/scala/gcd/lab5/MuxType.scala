package lab5
import chisel3._
import chisel3.util._

class MuxType[T <: Data](gen: T) extends Module {
  val io = IO(new Bundle {
    val out = Output(gen)
    val in1 = Input(gen)
    val in2 = Input(gen)
    val sel = Input(Bool())
  })
  
  def Mux2to1[E <: T](in_0: E, in_1: E, sel: Bool): E = {
    Mux(sel, in_1, in_0)
  }
  io.out := Mux2to1(io.in1, io.in2, io.sel)
}
