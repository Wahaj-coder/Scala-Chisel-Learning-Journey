package lab1

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class CounterMSBTest extends FreeSpec with ChiselScalatestTester{
    "CounterMS Tester file " in {
        test(new CounterMSB(7)){ a=>
        a.clock.step(40)
        a.io.out.expect(0.U)
       
        }
    }
}