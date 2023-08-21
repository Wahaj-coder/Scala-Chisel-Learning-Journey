package lab2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class  exc2Test extends FreeSpec with ChiselScalatestTester{
    "exc2 Tester file " in {
        test(new MuxLookupNested ){ a=>
      
        a.io.in0.poke(1.B)
        a.io.in1.poke(1.B)
        a.io.in2.poke(1.B)
        a.io.in3.poke(1.B)
        a.io.in4.poke(1.B)
        a.io.in5.poke(1.B)
        a.io.in6.poke(1.B)
        a.io.in7.poke(0.B)
        a.io.sel.poke(7.U)

        a.clock.step()
        a.io.out.expect(0.B)
       
        }
    }
}