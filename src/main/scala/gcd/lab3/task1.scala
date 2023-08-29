package lab3
import chisel3._
import chisel3.util._

class task1l3 extends Module {
  val io = IO(new Bundle {   
    val func3 = Input(UInt(3.W))
    val branch = Input(Bool())
    val x = Input(SInt(32.W))
    val y = Input(SInt(32.W))
    val brTaken = Output(Bool()) 
  })
    
  when(io.branch === 1.B) {
    when(io.func3 === 0.U) {
      io.brTaken := io.x === io.y
    }.elsewhen(io.func3 === 1.U) {
      io.brTaken := !(io.x === io.y)
    }.elsewhen(io.func3 === 4.U) {
      io.brTaken := io.x < io.y
    }.elsewhen(io.func3 === 5.U) {
      io.brTaken := io.x >= io.y
    }.elsewhen(io.func3 === 6.U) {
      io.brTaken := (io.x.asUInt() > io.y.asUInt()) || (io.x.asUInt() === io.y.asUInt())
    }.elsewhen(io.func3 === 7.U) {
      io.brTaken := io.x.asUInt() >= io.y.asUInt()
    }.otherwise {
      io.brTaken := 0.B
    }
  }.otherwise{
    io.brTaken := 0.B
  }
}
