// package lab3

// import chisel3._
// import chisel3.util._
// class LM_IO_Interface_ImmdValGen extends Bundle {
//   val instr = Input(UInt(32.W))
//   val immd_se = Output(UInt(32.W))
// }

// class task2l3 extends Module {
//   val io = IO(new LM_IO_Interface_ImmdValGen)

//   val immd = io.instr(31, 20)

//   val immd_se = Cat(Fill(20, immd(11)), immd)

//   io.immd_se := immd_se
// }