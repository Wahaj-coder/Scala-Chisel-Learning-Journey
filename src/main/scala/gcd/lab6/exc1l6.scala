package lab6
import chisel3._

class PipoReg(val init: UInt = 0.U(4.W)) extends Module {
  val io = IO(new Bundle {
    val parallelIn = Input(UInt(4.W))
    val parallelOut = Output(UInt(4.W))
  })

  val state = RegInit(init)


    state := io.parallelIn
  

  io.parallelOut := state
}
