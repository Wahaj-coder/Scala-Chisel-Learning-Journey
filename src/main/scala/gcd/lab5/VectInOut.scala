package lab5
import chisel3._
import chisel3.util._
class VectInOut[T <: Data](n: Int, generic: T)(op: (T, T) => T) extends Module {
  require(n > 0)
  
  val io = IO(new Bundle {
    val in = Input(Vec(n, generic))
    val out = Output(Vec(n, generic)) // Use Vec for the output as well
  })

  for (i <- 0 until n) {
    io.out(i) := op(io.in(i), io.in(i))
  }
}
