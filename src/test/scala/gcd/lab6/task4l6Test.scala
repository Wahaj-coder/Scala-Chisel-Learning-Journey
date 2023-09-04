// package lab6
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class task4l6Test extends FreeSpec with ChiselScalatestTester {
//   "task4l6" in {
//     test(new task4l6(7) ){ c =>   
//         c.io.UpDown.poke(1.B)
//         c.clock.step(10)
//         c.io.out.expect(2.U)

//         c.io.UpDown.poke(0.B)
//         c.clock.step(10)
//         c.io.out.expect(0.U)

//     }
//   }
// }
