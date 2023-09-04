package lab6
import chisel3._
import chisel3.util._

class task4l6(val max: Int) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(log2Ceil(max).W))
    val UpDown=Input(Bool())
  })

  val counter = RegInit(0.U(log2Ceil(max).W))
    
  val nextCounter = Mux(io.UpDown,
    Mux(counter === (max).U, 0.U, counter + 1.U),
    Mux((counter===0.U), max.asUInt(), counter - 1.U)
  )

  counter := nextCounter
  io.out := counter
}