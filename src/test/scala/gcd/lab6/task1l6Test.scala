package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task1l6Test extends FreeSpec with ChiselScalatestTester {
  "task1l6" in {
    test(new task1l6(4) ){ c =>   
        
        c.clock.step(5)
        c.io.out.expect(1.U)

    }
    test(new task1l6(13) ){ d =>   
        
        d.clock.step(15)
        d.io.out.expect(1.U)

    }
  }
}
