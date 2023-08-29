package lab1
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class UpDownTest extends FreeSpec with ChiselScalatestTester {
  "UpDownCounter test" in {
    test(new counter_up_down(4)){ a=>
        a.clock.step(12)
        a.io.out.expect(0.B)
  }
}
}