package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task2l6Test extends FreeSpec with ChiselScalatestTester {
  "task2l6" in {
    test(new task2l6(7) ){ c =>   
        
        c.clock.step(10)
        c.io.out.expect(0.U)

    }
  }
}
