package lab5

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class  ALUWhenTest extends FreeSpec with ChiselScalatestTester{
    "e1l5 Tester file " in {
        test(new ALUWhen(2)){ a=>

        a.io.X.poke(1.U)
        a.io.Y.poke(1.U)
        a.io.aluOp.poke(0.U)
        a.clock.step()
        a.io.out.expect(1.U)
       
        }
    }
}