package lab5

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class  Task1l5Test extends FreeSpec with ChiselScalatestTester{
    "t1l5 Tester file " in {
        test(new Task1l5(3)){ a=>

        a.io.in0.poke(1.U)
        a.io.in1.poke(1.U)
        a.clock.step()
        a.io.sum.expect(2.U)
       
        }
    }
}