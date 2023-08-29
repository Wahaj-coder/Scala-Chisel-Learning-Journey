// package lab3

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec

// class task1Testl3 extends FreeSpec with ChiselScalatestTester {
//   "t1l3 Tester file " in {
//     test(new task2l3) { a =>
//       a.io.func3.poke(1.U)
//       a.io.x.poke(8.S)
//       a.io.y.poke(7.S)
//       a.io.branch.poke(1.B)
//       a.io.brTaken.expect(1.B) // Expect brTaken to be 1
//       a.clock.step()
//     }
//   }
// }
