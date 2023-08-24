package lab3
import chisel3._
import chisel3.util._

object ALUOP {
  val ALU_ADD = 0.U(4.W)
  val ALU_SUB = 1.U(4.W)
  val ALU_AND = 2.U(4.W)
  val ALU_OR  = 3.U(4.W)
  val ALU_XOR = 4.U(4.W)
  val ALU_SLT = 5.U(4.W)
  val ALU_SLL = 6.U(4.W)
  val ALU_SLTU = 7.U(4.W)
  val ALU_SRL = 8.U(4.W)
  val ALU_SRA = 9.U(4.W)
  val ALU_COPY_A = 10.U(4.W)
  val ALU_COPY_B = 11.U(4.W)
  val ALU_XXX = 15.U(4.W)
}

trait Config {
  val XLEN = 32
  val ALUOP_SIG_LEN = 4
}

class ALUIO extends Bundle with Config {
  val in_A = Input(UInt(XLEN.W))
  val in_B = Input(UInt(XLEN.W))
  val alu_Op = Input(UInt(ALUOP_SIG_LEN.W))
  val out = Output(UInt(XLEN.W))
  val sum = Output(UInt(XLEN.W))
}

class exc2lab3 extends Module with Config {
  val io = IO(new ALUIO)
  import ALUOP._
  val sum = io.in_A + Mux(io.alu_Op(0), -io.in_B, io.in_B)
  val cmp = Mux(
    io.in_A(XLEN - 1) === io.in_B(XLEN - 1),
    sum(XLEN - 1),
    Mux(io.alu_Op(1), io.in_B(XLEN - 1), io.in_A(XLEN - 1))
  )
  val shamt = io.in_B(4, 0)
  val shin = Mux(io.alu_Op(3), io.in_B, Reverse(io.in_B))
  val shiftr = shin >> shamt
  val shiftl = shin << shamt

  val out = io.alu_Op
  switch(out) {
    is(ALUOP.ALU_SRA, ALUOP.ALU_SRL) {
      io.out := shiftr
    }
    is(ALUOP.ALU_SLT, ALUOP.ALU_SLTU) {
      io.out := cmp
    }
    is(ALUOP.ALU_ADD, ALUOP.ALU_SUB) {
      io.out := sum
    }
    is(ALUOP.ALU_SLL) {
      io.out := shiftl
    }
    is(ALUOP.ALU_AND) {
      io.out := io.in_A & io.in_B
    }
    is(ALUOP.ALU_OR) {
      io.out := io.in_A | io.in_B
    }
    is(ALUOP.ALU_XOR) {
      io.out := io.in_A ^ io.in_B
    }
    is(ALUOP.ALU_COPY_A) {
      io.out := io.in_A
    }
    is(ALUOP.ALU_COPY_B) {
      io.out := io.in_B
    }
    is(ALUOP.ALU_XXX) {
      io.out := 0.U
    }
  }

  io.sum := sum
}
