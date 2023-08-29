package lab4

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
    val ALU_SLTU= 7.U(4.W)
    val ALU_SRL = 8.U(4.W)
    val ALU_SRA = 9.U(4.W)
    val ALU_COPY_A = 10.U(4.W)
    val ALU_COPY_B = 11.U(4.W)
    val ALU_DIV = 12.U(4.W)
    val ALU_DIVU = 13.U(4.W)
    val ALU_REM = 14.U(4.W)
    val ALU_REMU = 15.U(4.W)
    val ALU_MUL = 16.U(5.W)
}

trait Config{
    val WLEN = 32
    val ALUOP_SIG_LEN = 5
}

import ALUOP._

class ALUIO extends Bundle with Config {
    val in_A = Input(UInt(WLEN.W))
    val in_B = Input(UInt(WLEN.W))
    val alu_Op = Input(UInt(ALUOP_SIG_LEN.W))
    val out = Output(UInt(WLEN.W))
    val sum = Output(UInt(WLEN.W))
}

class ALU extends Module with Config {
    val io = IO(new ALUIO)

    val sum = io.in_A + Mux(io.alu_Op(0), (-io.in_B) , io.in_B)
    val cmp = Mux(io.in_A < io.in_B, 1.U, 0.U)
    val shamt = io.in_B(4, 0).asUInt
    val shin = Mux(io.alu_Op(3), io.in_A, Reverse(io.in_A))
    val shiftr = (Cat(io.alu_Op(0) && shin(WLEN - 1), shin).asSInt >> shamt) (WLEN - 1, 0)
    val shitfl = Reverse(shiftr)
    val div = io.in_A / io.in_B
    val rem = io.in_A % io.in_B
    val mul = io.in_A * io.in_B

    val out =
    Mux((io.alu_Op === ALU_ADD) || (io.alu_Op === ALU_SUB), sum,
        Mux(io.alu_Op === ALU_SLT || io.alu_Op === ALU_SLTU, cmp,
            Mux(io.alu_Op === ALU_SRA || io.alu_Op === ALU_SRL,shiftr,
                Mux(io.alu_Op === ALU_SLL, shitfl,
                    Mux(io.alu_Op === ALU_AND, (io.in_A & io.in_B),
                        Mux(io.alu_Op === ALU_OR, (io.in_A | io.in_B),
                            Mux(io.alu_Op === ALU_XOR, (io.in_A ^ io.in_B),
                                Mux(io.alu_Op === ALU_COPY_A, io.in_A,
                                    Mux(io.alu_Op === ALU_COPY_B, io.in_B,
                                        Mux(io.alu_Op === ALU_DIV, div,
                                             Mux(io.alu_Op === ALU_DIV, div.asUInt(),
                                                 Mux(io.alu_Op === ALU_DIVU, div.asUInt(),
                                                    Mux(io.alu_Op === ALU_REM, rem ,
                                                        Mux(io.alu_Op === ALU_REM, rem.asUInt() ,
                                                             Mux(io.alu_Op === ALU_MUL, mul , 0.U)))))))))))))))

    io.out := out
    io.sum := sum
}