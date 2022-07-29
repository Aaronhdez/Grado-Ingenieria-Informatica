            .data
numero1:    .word 0x7fffffff
numero2:    .word 16
            .text
main:
		lw		$t0,numero1($0)           
		lw		$t1,numero2($0)      
		#mul		$t2,$t0,$t1
		#mul		$t2,$t0,$t1
		mulou		$t2,$t0,$t1
		jr		$31