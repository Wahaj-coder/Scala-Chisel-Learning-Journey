package lab5
import chisel3 . _
import chisel3 . util . _

class DataPackets[ T <: Data ]( gen : T )extends Bundle {
    val data = Input(gen)
    val address = Input(UInt(10.W))
}

class IO1Interface[T <: Data](gen: T) extends Bundle {
  val in = Input(new DataPackets(gen))
  val out = Output(new DataPackets(gen))
}

class Router[T <: Data](gen: T) extends Module {
  val io = IO(new IO1Interface(gen))

  io.out := io.in
}