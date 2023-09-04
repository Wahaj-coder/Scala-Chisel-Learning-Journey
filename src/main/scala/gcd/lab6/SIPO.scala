package lab6
import chisel3._

class SIPOShift(val init: UInt = 0.U(4.W)) extends Module {
  val io = IO(new Bundle {
    val serialIn = Input(Bool())
    val parallelOut = Output(UInt(4.W))
  })

  val state = RegInit(init)
  val nextState = ( state << 1) | io.serialIn
  state := nextState
  io.parallelOut := state
}