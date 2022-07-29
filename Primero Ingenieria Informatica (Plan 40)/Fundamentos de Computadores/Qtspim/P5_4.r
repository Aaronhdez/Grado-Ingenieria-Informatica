            .data 0x10000000
num:		.word 20, 30
			.align 2
            .text
main:
		la		$t0,num($0)
		lw		$t1,0($t0)           
		lw		$t2,4($t0)      
		add		$s0,$t1,$t2
		sw		$s0,8($t0)
		jr		$31