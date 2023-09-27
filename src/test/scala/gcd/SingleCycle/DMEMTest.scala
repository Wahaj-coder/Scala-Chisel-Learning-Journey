// package lab7
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class DMEMTest extends FreeSpec with ChiselScalatestTester {
//   "DMEM" in {
//     test(new DMEM){ a =>   
//     a.io.data_in.poke("b0001001001001000".U)  
//     a.io.wen.poke(1.B)
//     a.io.address.poke(0.U)
//     a.io.func3.poke(0.U)
//     a.io.byteLocat.poke(0.U)
//     a.clock.step(1)
    
    
//     a.io.wen.poke(0.B)
    
//     a.io.func3.poke(4.U)
    
//     a.clock.step(2)
//     a.io.data_out(0).expect("b01001000".U)
//     a.io.data_out(2).expect("b00000000".U)
//     a.io.data_out(1).expect("b00000000".U)
//     a.io.rd.expect("b01001000".U)
   
//     }
//   }
// }
