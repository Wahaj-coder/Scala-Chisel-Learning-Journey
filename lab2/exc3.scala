package lab2
import chisel3._
import chisel3.util._

class exc3 extends Module {
   val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val select = Input(UInt(2.W))
    val out = Output(UInt(2.W))
  })

  val upperTwoBits = io.in(3, 2)
  val lowerTwoBits = io.in(1, 0)

  val encodedOutput = Mux1H(io.select, Seq(upperTwoBits, lowerTwoBits))

  io.out := encodedOutput
}