            .data 0x10000000
num:		.word -1215
			.data 0x10000010
num2:		.word 18
			.align 2
            .text
main:
		li		$s0,0
		li		$s1,2
		li		$s2,5
		la		$t0,num($0)

bucle:	
	
		lw		$s4,0($t0)
		div		$s3,$s4,$s2
		sw		$s3,4($t0)
		addi	$t0,$t0,16
		addi	$s0,$s0,1
		and		$s3,$s3,$0
		bne		$s0,$s1,bucle
		jr		$31