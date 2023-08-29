package lab2
import chisel3._
import chisel3.util._
// Mux IO interface class
class Mux2to1IO extends Bundle {
  val in_A = Input(UInt(32.W))
  val in_B = Input(UInt(32.W))
  val select = Input(Bool())
  val out = Output(UInt(32.W))
}

// 2 to 1 Mux implementation using combinational logic
class exc1 extends Module {
  val io = IO(new Mux2to1IO)

  // Generate mux output using combinational logic
  io.out := Mux(io.select, io.in_B, io.in_A)
  
}