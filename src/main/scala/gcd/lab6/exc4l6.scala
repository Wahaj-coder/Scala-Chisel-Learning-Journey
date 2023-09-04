package lab6
import chisel3._
import chisel3.util._

class M1 extends Module {
  
  val io = IO(new Bundle {
    val in = Flipped(Decoupled(UInt(8.W))) // valid = Input , ready = Output , bits = Input
    val out = Decoupled(UInt(8.W)) // valid = Output , ready = Input , bits = Output
  })

  val queue1 = Queue(io.in, 5) // 5-element queue
  val queue2 = Queue(queue1, 5) // 5-element queue
  io.out <> queue2
}



