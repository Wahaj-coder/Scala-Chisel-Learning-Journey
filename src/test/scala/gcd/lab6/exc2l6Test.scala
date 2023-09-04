package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class exc2l6Test extends FreeSpec with ChiselScalatestTester {
  "exc2l6" in {
    test(new exc2l6(9) ){ c =>   
              
        c.clock.step(11)
        c.io.out.expect(1.U)

    }
  }
}
