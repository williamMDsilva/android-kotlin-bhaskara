package com.example.calcbaskara

import androidx.appcompat.app.AppCompatActivity

class Baskara(
        private val a: Double,
        private val b : Double,
        private val c : Double
) {

    private fun delta(): Double{
        var daltpI :Double =  Math.pow(this.b, 2.0);

        var daltpII : Double = 4 * this.a * this.c;

        return daltpI - daltpII;
    }

    public fun l1() : Double{
        var delta = this.delta();
        var bl: Double = (-1) * this.b;
        var al = 2 * this.a

        return ( (bl) + Math.sqrt(delta) ) / (al)
    }
    
    public fun l2(): Double{
        var delta = this.delta();
        var bl: Double = (-1) * this.b;
        var al = 2 * this.a

        return ( (bl) - Math.sqrt(delta) ) / (al)
    }
}