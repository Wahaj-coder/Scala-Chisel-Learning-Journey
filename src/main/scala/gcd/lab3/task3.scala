package lab3

import chisel3._
import chisel3.util._

class LM_IO_Interface_decoder_with_valid extends Bundle {
  val in = Input(UInt(2.W))
  val out = Valid(Output(UInt(4.W)))
}

class task3l3 extends Module {
  val io = IO(new LM_IO_Interface_decoder_with_valid)
  io.out.bits := 0.U
  io.out.valid := 0.U
  when(io.in === "b00".U) {
    io.out.bits := "b0001".U
    io.out.valid := 1.U
  } .elsewhen(io.in === "b01".U) {
    io.out.bits := "b0010".U
    io.out.valid := 1.U
  } .elsewhen(io.in === "b10".U) {
    io.out.bits := "b0100".U
    io.out.valid := 1.U
  } .otherwise {
    io.out.bits := "b1000".U
    io.out.valid := 1.U
  }
}
