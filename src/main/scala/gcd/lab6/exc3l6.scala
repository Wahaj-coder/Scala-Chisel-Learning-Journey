package lab6
import chisel3 . _
import chisel3 . util . _
class exc3l6 ( val maxWidth : Int ) extends Module {
val io = IO ( new Bundle {
    val trigger = Input(Bool())   // Input trigger signal
    val reload = Input(Bool())    // Reload signal
    val din = Input(UInt(maxWidth.W)) // Input value for reloading
    val out = Output(Bool())    // Output pulse
})
    io.out:=0.B
    val timer_count = RegInit (0.U(maxWidth.W))
    val done = timer_count === 0. U
    val next = WireInit (0. U )
    when (io.reload) {
    timer_count := io.din
    io.out:=1.B
  }
    .elsewhen (io.trigger) {
     timer_count := io.din
     io.out := 1.B
  }
     .elsewhen (!done) {
     timer_count := timer_count - 1.U
     io.out:=0.B
  }
}