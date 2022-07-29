            .data
numero1:    .word 17
numero2:    .word 5
            .text
main:
		lw		$t0,numero1($0)           
		lw		$t1,numero2($0)      
		#div		$t2,$t0,$t1   
		divu		$t2,$t0,$t1
		jr		$31