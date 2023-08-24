package lab3

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class  exc2lab3Test extends FreeSpec with ChiselScalatestTester{
    "e2l3 Tester file " in {
        test(new exc2lab3){ a=>
        a.io.alu_Op.poke("b0001".U)
        a.io.in_A.poke(8.U)
        a.io.in_B.poke(8.U)        
        a.io.sum.expect(8.U)
        a.clock.step(1)    
        a.io.out.expect(16.U)      
        }
    }
}