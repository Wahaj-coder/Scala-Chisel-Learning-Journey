package lab3
import chisel3._
import chisel3.util._

class DecoderIO extends Bundle {
  val inp = Input(UInt(4.W))
  val out = Output(UInt(2.W))
}

class exc1l3 extends Module {
  val io = IO(new DecoderIO)

  io.out := 0.U

  switch(io.inp) {
    is("b0001".U) {
      io.out := "b00".U
    }
    is("b0010".U) {
      io.out := "b01".U
    }
    is("b0100".U) {
      io.out := "b10".U
    }
    is("b1000".U) {
      io.out := "b11".U
    }
  }
}