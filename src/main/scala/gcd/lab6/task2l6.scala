package lab6
import chisel3._
import chisel3.util._

class task2l6(val max: Int) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(log2Ceil(max).W))
  })

  val counter = RegInit(0.U(log2Ceil(max).W))
  val msb = counter(log2Ceil(max) - 1)

  val nextCounter = Mux(isPow2(max).B,
    Mux(counter === (max - 1).U, 0.U, counter + 1.U),
    Mux(msb, 0.U, counter + 1.U)
  )

  counter := nextCounter
  io.out := counter
}