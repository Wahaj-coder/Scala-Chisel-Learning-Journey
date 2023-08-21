package lab2
import chisel3 . _
import chisel3.util._
class IOinter extends Bundle {
import chisel3.util._
val s0=Input ( Bool () )
val s1=Input ( Bool () )
val s2=Input ( Bool () )
val out=Output ( UInt (32. W ) )
}


class task1 extends Module {
  val io = IO(new IOinter)

  // Implement the 5-to-1 multiplexer logic here
  val output = MuxCase(32.U, Array(
    (!io.s2 && !io.s1 && !io.s0) -> 0.U,
    (!io.s2 && !io.s1 && io.s0)  -> 8.U,
    (!io.s2 && io.s1 && !io.s0)  -> 16.U,
    (!io.s2 && io.s1 && io.s0)   -> 24.U,
    
  ))

  // Connect the output to the output port
  io.out := output
}