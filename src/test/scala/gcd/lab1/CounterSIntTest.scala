package lab1

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class CounterSIntTest extends FreeSpec with ChiselScalatestTester{
    "CounterSInt Tester file " in {
        test(new CounterSInt(2.S)){ a=>
        a.clock.step(3)
        a.io.out.expect(0.S)
       
        }
    }
}