.data
	tex1:	.asciiz "La cadena '"
	tex2:	.asciiz "' tiene "
	tex3: 	.asciiz " letras a y b hasta el primer valor de caracter 0 o espacio."
			.align 4
	res:	.space 8
			.align 4
	cadena:	.asciiz "estaesunaprueba bbb"
			
.text

main:
	la $t0,cadena
	li $t1,0x61
	li $t2,0x62
	li $t3,0x20
	li $t7,19	#limite, contando espacios
	li $s0,0

# Contador de letras con dos contadores, uno para cada letra
	
count:
	la $t0,cadena
	andi $s1,$s1,0
	andi $s2,$s2,0
	andi $s3,$s3,0
loop_ini:
	lb $t4,0($t0)
	addi $t0,$t0,1
	beq $t4,$t3,store
	bne $t4,$t1,check_b
	addi $s0,$s0,1
	j loop_end
check_b:
	bne $t4,$t2,loop_end
	addi $s0,$s0,1
loop_end:
	beq	$s3,$t7,store
	addi $s3,$s3,1
	j loop_ini
	
store:
	la $t0,res
	sw $s0,0($t0)
	addi $t0,$t0,4
	sw $s1,0($t0)

# Final
	
display:
	la $a0,tex1
	li $v0,4
	syscall
	la $a0,cadena
	li $v0,4
	syscall	
	la $a0,tex2
	li $v0,4
	syscall
	la $t0,res
	lw $a0,0($t0)
	li $v0,1
	syscall
	la $a0,tex3
	li $v0,4
	syscall
	jr $31
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	