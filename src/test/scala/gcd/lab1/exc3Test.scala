package lab1

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class CounterMethodTest extends FreeSpec with ChiselScalatestTester{
    "CounterMethod Tester file " in {
        test(new CounterMethod(2,2)){ a=>
        a.clock.step(4)
        a.io.result.expect(0.B)
       
        }
    }
}