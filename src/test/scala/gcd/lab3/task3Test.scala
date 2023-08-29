// package lab3

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec

// class task3Testl3 extends FreeSpec with ChiselScalatestTester {
//   "t3l3 Tester file " in {
//     test(new task3l3) { a =>
//       a.io.in.poke(0.U) 
//       a.clock.step()
//       a.io.out.bits.expect("b0001".U)
//       a.io.out.valid.expect(true.B)
//     }
//   }
// }
