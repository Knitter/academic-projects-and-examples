	.386p
	ifdef ??version
	if    ??version GT 500H
	.mmx
	endif
	endif
	model flat
	ifndef	??version
	?debug	macro
	endm
	endif
	?debug	S "C:\Documents and Settings\Rita\Ambiente de trabalho\trabalho ac sergio\versao2.0\versao2_0.cpp"
	?debug	T "C:\Documents and Settings\Rita\Ambiente de trabalho\trabalho ac sergio\versao2.0\versao2_0.cpp"
_TEXT	segment dword public use32 'CODE'
_TEXT	ends
_DATA	segment dword public use32 'DATA'
_DATA	ends
_BSS	segment dword public use32 'BSS'
_BSS	ends
$$BSYMS	segment byte public use32 'DEBSYM'
$$BSYMS	ends
$$BTYPES	segment byte public use32 'DEBTYP'
$$BTYPES	ends
$$BNAMES	segment byte public use32 'DEBNAM'
$$BNAMES	ends
$$BROWSE	segment byte public use32 'DEBSYM'
$$BROWSE	ends
$$BROWFILE	segment byte public use32 'DEBSYM'
$$BROWFILE	ends
 ?debug  C FB0C0100600000
DGROUP	group	_BSS,_DATA
_BSS	segment dword public use32 'BSS'
	align	4
_Form1	label	dword
	db	4	dup(?)
_BSS	ends
_DATA	segment dword public use32 'DATA'
@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent	segment virtual
	align	2
@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent	label	dword
	dd	@@$xt$p6TForm1
	dd	1029
	dd	-4
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-8
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-12
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-16
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-20
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-24
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-28
	dd	0
@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTEE$@TForm1@$bctr$qqrp18Classes@TComponent	segment virtual
	align	2
@@_$ECTEE$@TForm1@$bctr$qqrp18Classes@TComponent	label	dword
	dd	0
	dd	-64
	dw	0
	dw	5
	dd	0
	dd	@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent
	dw	8
	dw	5
	dd	15
	dd	@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent+16
	dw	8
	dw	5
	dd	15
	dd	@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent+32
	dw	8
	dw	5
	dd	15
	dd	@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent+48
	dw	8
	dw	5
	dd	15
	dd	@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent+64
	dw	8
	dw	5
	dd	15
	dd	@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent+80
	dw	8
	dw	5
	dd	15
	dd	@@_$DCDE$@TForm1@$bctr$qqrp18Classes@TComponent+96
@_$ECTEE$@TForm1@$bctr$qqrp18Classes@TComponent	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@$bctr$qqrp18Classes@TComponent	segment virtual
@@TForm1@$bctr$qqrp18Classes@TComponent	proc	near
?live16385@0:
	?debug L 32
	push      ebp
	mov       ebp,esp
	add       esp,-76
	mov       byte ptr [ebp-32],dl
	test      dl,dl
	jle       short @1
	call      __ClassCreate
@1:
	mov       dword ptr [ebp-72],ecx
	mov       byte ptr [ebp-65],dl
	mov       dword ptr [ebp-4],eax
@2:
	mov       eax,offset @@_$ECTEE$@TForm1@$bctr$qqrp18Classes@TComponent
	call      @__InitExceptBlockLDTC
	?debug L 33
	mov       word ptr [ebp-48],8
	mov       ecx,dword ptr [ebp-72]
	xor       edx,edx
	mov       eax,dword ptr [ebp-4]
	call      @@Forms@TForm@$bctr$qqrp18Classes@TComponent
	add       dword ptr [ebp-36],15
	?debug L 35
	mov       edx,dword ptr [ebp-4]
	mov       eax,dword ptr [edx+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       dword ptr [ebp-76],eax
	?debug L 36
	push      16777215
	push      0
	xor       ecx,ecx
	xor       edx,edx
	mov       eax,dword ptr [ebp-76]
	call      @@Graphics@TCanvas@FloodFill$qqrii15Graphics@TColor19Graphics@TFillStyle
	?debug L 37
	mov       word ptr [ebp-48],20
	mov       edx,offset s@
	lea       eax,dword ptr [ebp-8]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       ecx,dword ptr [ebp-4]
	mov       eax,dword ptr [ecx+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-8]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 39
	mov       ecx,dword ptr [ebp-4]
	mov       eax,dword ptr [ecx+732]
	xor       edx,edx
	call      @@Stdctrls@TCustomComboBox@SetItemIndex$qqri
	?debug L 40
	mov       word ptr [ebp-48],32
	mov       edx,offset s@+75
	lea       eax,dword ptr [ebp-12]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-4]
	mov       eax,dword ptr [eax+768]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-12]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 41
	mov       word ptr [ebp-48],44
	mov       edx,offset s@+78
	lea       eax,dword ptr [ebp-16]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-4]
	mov       eax,dword ptr [eax+772]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-16]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 42
	mov       word ptr [ebp-48],56
	mov       edx,offset s@+81
	lea       eax,dword ptr [ebp-20]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-4]
	mov       eax,dword ptr [eax+760]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-20]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 43
	mov       word ptr [ebp-48],68
	mov       edx,offset s@+85
	lea       eax,dword ptr [ebp-24]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-4]
	mov       eax,dword ptr [eax+764]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-24]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 44
	mov       word ptr [ebp-48],80
	mov       edx,offset s@+89
	lea       eax,dword ptr [ebp-28]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-4]
	mov       eax,dword ptr [eax+796]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-28]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 45
	mov       ecx,dword ptr [ebp-64]
	mov       dword ptr fs:[0],ecx
	mov       eax,dword ptr [ebp-4]
@4:
@3:
	cmp       byte ptr [ebp-65],0
	je        short @5
	call      __AfterConstruction
	?debug L 45
@5:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@TForm1@$bctr$qqrp18Classes@TComponent	endp
@TForm1@$bctr$qqrp18Classes@TComponent	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	db	2
	db	0
	db	0
	db	0
	dw	85
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch1
	dd	?patch2
	dd	?patch3
	df	@@TForm1@$bctr$qqrp18Classes@TComponent
	dw	0
	dw	4315
	dw	0
	dw	168
	dw	0
	dw	0
	dw	0
	db	38
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	36
	db	98
	db	99
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	112
	db	49
	db	56
	db	67
	db	108
	db	97
	db	115
	db	115
	db	101
	db	115
	db	64
	db	84
	db	67
	db	111
	db	109
	db	112
	db	111
	db	110
	db	101
	db	110
	db	116
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4291
	dw	0
	dw	169
	dw	0
	dw	0
	dw	0
	dw	?patch4
	dw	529
	dw	?patch5
	dd	?live16385@0-@@TForm1@$bctr$qqrp18Classes@TComponent
	dd	?live16385@0-?live16385@0
	dw	17
?patch5	equ	1
?patch4	equ	14
	dw	18
	dw	512
	dw	65464
	dw	65535
	dw	65522
	dw	65535
	dw	170
	dw	0
	dw	0
	dw	0
	dw	?patch6
	dw	529
	dw	?patch7
	dd	?live16385@0-@@TForm1@$bctr$qqrp18Classes@TComponent
	dd	?live16385@0-?live16385@0
	dw	18
?patch7	equ	1
?patch6	equ	14
	dw	18
	dw	512
	dw	65460
	dw	65535
	dw	65531
	dw	65535
	dw	171
	dw	0
	dw	0
	dw	0
?patch1	equ	@4-@@TForm1@$bctr$qqrp18Classes@TComponent+15
?patch2	equ	0
?patch3	equ	@4-@@TForm1@$bctr$qqrp18Classes@TComponent
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCFE$@TForm1@BitBtn1Click$qqrp14System@TObject	segment virtual
	align	2
@@_$DCFE$@TForm1@BitBtn1Click$qqrp14System@TObject	label	dword
	dd	@@$xt$p13Windows@TRect
	dd	8199
	dd	-4
	dd	0
@_$DCFE$@TForm1@BitBtn1Click$qqrp14System@TObject	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTGE$@TForm1@BitBtn1Click$qqrp14System@TObject	segment virtual
	align	2
@@_$ECTGE$@TForm1@BitBtn1Click$qqrp14System@TObject	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	0
	dw	8
	dw	5
	dd	0
	dd	@@_$DCFE$@TForm1@BitBtn1Click$qqrp14System@TObject
@_$ECTGE$@TForm1@BitBtn1Click$qqrp14System@TObject	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@BitBtn1Click$qqrp14System@TObject	segment virtual
@@TForm1@BitBtn1Click$qqrp14System@TObject	proc	near
?live16391@0:
	?debug L 47
	push      ebp
	mov       ebp,esp
	add       esp,-52
	mov       dword ptr [ebp-48],edx
	mov       dword ptr [ebp-44],eax
@6:
	mov       eax,offset @@_$ECTGE$@TForm1@BitBtn1Click$qqrp14System@TObject
	call      @__InitExceptBlockLDTC
	?debug L 49
	push      16
	call      @$bnew$qui
	pop       ecx
	mov       dword ptr [ebp-4],eax
	test      eax,eax
	je        short @7
	mov       word ptr [ebp-24],20
	mov       edx,dword ptr [ebp-44]
	mov       ecx,dword ptr [edx+720]
	push      dword ptr [ecx+60]
	mov       eax,dword ptr [ebp-44]
	mov       edx,dword ptr [eax+720]
	push      dword ptr [edx+56]
	push      0
	push      0
	push      dword ptr [ebp-4]
	call      @@Windows@TRect@$bctr$qiiii
	add       esp,20
	mov       word ptr [ebp-24],8
	mov       ecx,dword ptr [ebp-4]
	jmp       short @8
@7:
	mov       ecx,dword ptr [ebp-4]
@8:
	mov       dword ptr [ebp-52],ecx
	?debug L 50
	mov       eax,dword ptr [ebp-44]
	mov       eax,dword ptr [eax+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       edx,dword ptr [ebp-52]
	call      @@Graphics@TCanvas@FillRect$qqrrx13Windows@TRect
	?debug L 51
	push      dword ptr [ebp-52]
	call      @$bdele$qpv
	pop       ecx
	?debug L 52
	mov       ecx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],ecx
	?debug L 52
@9:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@TForm1@BitBtn1Click$qqrp14System@TObject	endp
@TForm1@BitBtn1Click$qqrp14System@TObject	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	88
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch8
	dd	?patch9
	dd	?patch10
	df	@@TForm1@BitBtn1Click$qqrp14System@TObject
	dw	0
	dw	4343
	dw	0
	dw	172
	dw	0
	dw	0
	dw	0
	db	41
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	66
	db	105
	db	116
	db	66
	db	116
	db	110
	db	49
	db	67
	db	108
	db	105
	db	99
	db	107
	db	36
	db	113
	db	113
	db	114
	db	112
	db	49
	db	52
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	84
	db	79
	db	98
	db	106
	db	101
	db	99
	db	116
	dw	18
	dw	512
	dw	65492
	dw	65535
	dw	4291
	dw	0
	dw	173
	dw	0
	dw	0
	dw	0
	dw	?patch11
	dw	529
	dw	?patch12
	dd	?live16391@0-@@TForm1@BitBtn1Click$qqrp14System@TObject
	dd	?live16391@0-?live16391@0
	dw	17
?patch12	equ	1
?patch11	equ	14
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	65528
	dw	65535
	dw	174
	dw	0
	dw	0
	dw	0
	dw	?patch13
	dw	529
	dw	?patch14
	dd	?live16391@0-@@TForm1@BitBtn1Click$qqrp14System@TObject
	dd	?live16391@0-?live16391@0
	dw	19
?patch14	equ	1
?patch13	equ	14
	dw	18
	dw	512
	dw	65484
	dw	65535
	dw	65510
	dw	65535
	dw	175
	dw	0
	dw	0
	dw	0
?patch8	equ	@9-@@TForm1@BitBtn1Click$qqrp14System@TObject+4
?patch9	equ	0
?patch10	equ	@9-@@TForm1@BitBtn1Click$qqrp14System@TObject
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject	segment virtual
	align	2
@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject	label	dword
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-4
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-8
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-12
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-16
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-20
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-24
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-28
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-32
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-36
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-40
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-44
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-48
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-52
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-56
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-60
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-64
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-68
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-72
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-76
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-80
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-84
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-88
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-92
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-96
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-100
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-104
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-108
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-112
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-116
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-120
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-124
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-128
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-132
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-136
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-140
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-144
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-148
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-152
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-156
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-160
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-164
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-168
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-172
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-176
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-180
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-184
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-188
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-192
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-196
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-200
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-204
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-208
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-212
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-216
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-220
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-224
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-228
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-232
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-236
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-240
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-244
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-248
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-252
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-256
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-260
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-264
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-268
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-272
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-276
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-280
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-284
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-288
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-292
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-296
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-300
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-304
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-308
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-312
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-316
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-320
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-324
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-328
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-332
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-336
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-340
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-344
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-348
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-352
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-356
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-360
	dd	0
@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTIE$@TForm1@DesenhaClick$qqrp14System@TObject	segment virtual
	align	2
@@_$ECTIE$@TForm1@DesenhaClick$qqrp14System@TObject	label	dword
	dd	0
	dd	-396
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+16
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+32
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+48
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+64
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+80
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+96
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+112
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+128
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+144
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+160
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+176
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+192
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+220
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+248
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+300
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+316
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+332
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+348
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+376
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+404
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+456
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+472
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+488
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+504
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+532
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+560
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+612
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+628
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+644
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+660
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+688
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+716
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+756
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+820
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+836
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+852
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+868
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+896
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+924
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+976
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1040
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1056
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1072
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1088
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1116
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1144
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1184
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1248
	dw	0
	dw	5
	dd	0
	dd	@@_$DCHE$@TForm1@DesenhaClick$qqrp14System@TObject+1264
@_$ECTIE$@TForm1@DesenhaClick$qqrp14System@TObject	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@DesenhaClick$qqrp14System@TObject	segment virtual
@@TForm1@DesenhaClick$qqrp14System@TObject	proc	near
?live16396@0:
	?debug L 54
	push      ebp
	mov       ebp,esp
	add       esp,-408
	push      ebx
	mov       dword ptr [ebp-404],edx
	mov       dword ptr [ebp-400],eax
@10:
	mov       eax,offset @@_$ECTIE$@TForm1@DesenhaClick$qqrp14System@TObject
	call      @__InitExceptBlockLDTC
	?debug L 56
	mov       byte ptr [ebp-405],0
	?debug L 58
	mov       word ptr [ebp-380],8
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@Length$xqqrv
	test      eax,eax
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-4]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	je        short @11
	?debug L 59
	mov       word ptr [ebp-380],20
	mov       edx,offset s@+93
	lea       eax,dword ptr [ebp-8]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+768]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-8]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 60
@11:
	mov       word ptr [ebp-380],32
	lea       eax,dword ptr [ebp-12]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-12]
	call      @@System@AnsiString@Length$xqqrv
	test      eax,eax
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-12]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	je        short @12
	?debug L 61
	mov       word ptr [ebp-380],44
	mov       edx,offset s@+96
	lea       eax,dword ptr [ebp-16]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+772]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-16]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 62
@12:
	mov       word ptr [ebp-380],56
	lea       eax,dword ptr [ebp-20]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-20]
	call      @@System@AnsiString@Length$xqqrv
	test      eax,eax
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-20]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	je        short @13
	?debug L 63
	mov       word ptr [ebp-380],68
	mov       edx,offset s@+99
	lea       eax,dword ptr [ebp-24]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+760]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-24]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 64
@13:
	mov       word ptr [ebp-380],80
	lea       eax,dword ptr [ebp-28]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-28]
	call      @@System@AnsiString@Length$xqqrv
	test      eax,eax
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-28]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	je        short @14
	?debug L 65
	mov       word ptr [ebp-380],92
	mov       edx,offset s@+103
	lea       eax,dword ptr [ebp-32]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+764]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-32]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 66
@14:
	mov       word ptr [ebp-380],104
	lea       eax,dword ptr [ebp-36]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+796]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-36]
	call      @@System@AnsiString@Length$xqqrv
	test      eax,eax
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-36]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	je        short @15
	?debug L 67
	mov       word ptr [ebp-380],116
	mov       edx,offset s@+107
	lea       eax,dword ptr [ebp-40]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+796]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-40]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 68
@15:
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ApagaImagem$qqrv
	?debug L 70
	mov       edx,dword ptr [ebp-400]
	mov       eax,dword ptr [edx+732]
	call      @@Stdctrls@TCustomComboBox@GetItemIndex$qqrv
	cmp       eax,5
	ja        @16
	jmp       dword ptr [@24+4*eax]
@24:
	dd        @23
	dd        @22
	dd        @21
	dd        @20
	dd        @19
	dd        @18
	?debug L 72
@23:
	push      638
	mov       word ptr [ebp-380],128
	lea       eax,dword ptr [ebp-44]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-44]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-44]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 73
	push      478
	mov       word ptr [ebp-380],140
	lea       eax,dword ptr [ebp-48]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-48]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-48]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 74
	push      639
	lea       eax,dword ptr [ebp-56]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-56]
	call      @@System@AnsiString@ToInt$xqqrv
	inc       eax
	push      eax
	mov       word ptr [ebp-380],152
	lea       eax,dword ptr [ebp-52]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-52]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-56]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-52]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 75
	push      479
	lea       eax,dword ptr [ebp-64]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-64]
	call      @@System@AnsiString@ToInt$xqqrv
	inc       eax
	push      eax
	mov       word ptr [ebp-380],164
	lea       eax,dword ptr [ebp-60]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-60]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-64]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-60]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 77
	lea       eax,dword ptr [ebp-76]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-76]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-80]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-80]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-72]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-72]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	mov       word ptr [ebp-380],176
	lea       eax,dword ptr [ebp-68]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-68]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@DesenhaRectangulo$qqrssss
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-80]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-76]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-72]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-68]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 78
	mov       word ptr [ebp-380],188
	mov       edx,offset s@+110
	lea       eax,dword ptr [ebp-84]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-84]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 79
	mov       byte ptr [ebp-405],1
	?debug L 80
	jmp       @26
	?debug L 82
@22:
	push      638
	mov       word ptr [ebp-380],200
	lea       eax,dword ptr [ebp-88]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-88]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-88]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 83
	push      477
	mov       word ptr [ebp-380],212
	lea       eax,dword ptr [ebp-92]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-92]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-92]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 84
	push      639
	lea       eax,dword ptr [ebp-100]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-100]
	call      @@System@AnsiString@ToInt$xqqrv
	inc       eax
	push      eax
	mov       word ptr [ebp-380],224
	lea       eax,dword ptr [ebp-96]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-96]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-100]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-96]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 85
	push      479
	lea       eax,dword ptr [ebp-108]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-108]
	call      @@System@AnsiString@ToInt$xqqrv
	add       eax,2
	push      eax
	mov       word ptr [ebp-380],236
	lea       eax,dword ptr [ebp-104]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-104]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-108]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-104]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 87
	lea       eax,dword ptr [ebp-120]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-120]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-124]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-124]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-116]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-116]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	mov       word ptr [ebp-380],248
	lea       eax,dword ptr [ebp-112]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-112]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@DesenhaTriangulo$qqrssss
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-124]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-120]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-116]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-112]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 88
	mov       word ptr [ebp-380],260
	mov       edx,offset s@+128
	lea       eax,dword ptr [ebp-128]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-128]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 89
	mov       byte ptr [ebp-405],1
	?debug L 90
	jmp       @26
	?debug L 92
@21:
	push      637
	mov       word ptr [ebp-380],272
	lea       eax,dword ptr [ebp-132]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-132]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-132]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 93
	push      477
	mov       word ptr [ebp-380],284
	lea       eax,dword ptr [ebp-136]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-136]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-136]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 94
	push      639
	lea       eax,dword ptr [ebp-144]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-144]
	call      @@System@AnsiString@ToInt$xqqrv
	add       eax,2
	push      eax
	mov       word ptr [ebp-380],296
	lea       eax,dword ptr [ebp-140]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-140]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-144]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-140]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 95
	push      479
	lea       eax,dword ptr [ebp-152]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-152]
	call      @@System@AnsiString@ToInt$xqqrv
	add       eax,2
	push      eax
	mov       word ptr [ebp-380],308
	lea       eax,dword ptr [ebp-148]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-148]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-152]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-148]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 97
	lea       eax,dword ptr [ebp-164]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-164]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-168]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-168]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-160]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-160]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	mov       word ptr [ebp-380],320
	lea       eax,dword ptr [ebp-156]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-156]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@DesenhaLosango$qqrssss
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-168]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-164]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-160]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-156]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 98
	mov       word ptr [ebp-380],332
	mov       edx,offset s@+145
	lea       eax,dword ptr [ebp-172]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-172]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 99
	mov       byte ptr [ebp-405],1
	?debug L 100
	jmp       @26
	?debug L 102
@20:
	push      637
	mov       word ptr [ebp-380],344
	lea       eax,dword ptr [ebp-176]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-176]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-176]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 103
	push      478
	mov       word ptr [ebp-380],356
	lea       eax,dword ptr [ebp-180]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-180]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-180]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 104
	push      639
	lea       eax,dword ptr [ebp-188]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-188]
	call      @@System@AnsiString@ToInt$xqqrv
	add       eax,2
	push      eax
	mov       word ptr [ebp-380],368
	lea       eax,dword ptr [ebp-184]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-184]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-188]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-184]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 105
	push      479
	lea       eax,dword ptr [ebp-196]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-196]
	call      @@System@AnsiString@ToInt$xqqrv
	inc       eax
	push      eax
	mov       word ptr [ebp-380],380
	lea       eax,dword ptr [ebp-192]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-192]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-196]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-192]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 106
	lea       eax,dword ptr [ebp-208]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-208]
	call      @@System@AnsiString@ToInt$xqqrv
	dec       eax
	push      eax
	lea       eax,dword ptr [ebp-204]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-204]
	call      @@System@AnsiString@ToInt$xqqrv
	inc       eax
	push      eax
	mov       word ptr [ebp-380],392
	lea       eax,dword ptr [ebp-200]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+796]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-200]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-208]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-204]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-200]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 108
	lea       eax,dword ptr [ebp-220]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-220]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-224]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-224]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-228]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+796]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-228]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-216]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-216]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	mov       word ptr [ebp-380],404
	lea       eax,dword ptr [ebp-212]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-212]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@DesenhaParalelogramo$qqrsssss
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-228]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-224]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-220]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-216]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-212]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 109
	mov       word ptr [ebp-380],416
	mov       edx,offset s@+162
	lea       eax,dword ptr [ebp-232]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-232]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 110
	mov       byte ptr [ebp-405],1
	?debug L 111
	jmp       @26
	?debug L 113
@19:
	push      636
	mov       word ptr [ebp-380],428
	lea       eax,dword ptr [ebp-236]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-236]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-236]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 114
	push      478
	mov       word ptr [ebp-380],440
	lea       eax,dword ptr [ebp-240]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-240]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-240]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 115
	push      639
	lea       eax,dword ptr [ebp-248]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-248]
	call      @@System@AnsiString@ToInt$xqqrv
	add       eax,3
	push      eax
	mov       word ptr [ebp-380],452
	lea       eax,dword ptr [ebp-244]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-244]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-248]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-244]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 116
	push      479
	lea       eax,dword ptr [ebp-256]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-256]
	call      @@System@AnsiString@ToInt$xqqrv
	inc       eax
	push      eax
	mov       word ptr [ebp-380],464
	lea       eax,dword ptr [ebp-252]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-252]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-256]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-252]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 117
	lea       eax,dword ptr [ebp-272]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-272]
	call      @@System@AnsiString@ToInt$xqqrv
	dec       eax
	push      eax
	lea       eax,dword ptr [ebp-264]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-264]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       ebx,eax
	lea       eax,dword ptr [ebp-268]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-268]
	call      @@System@AnsiString@ToInt$xqqrv
	add       ebx,eax
	sar       ebx,1
	jns       short @48
	adc       ebx,0
@48:
	inc       ebx
	push      ebx
	mov       word ptr [ebp-380],476
	lea       eax,dword ptr [ebp-260]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+796]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-260]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-272]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-268]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-264]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-260]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 119
	lea       eax,dword ptr [ebp-284]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-284]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-288]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-288]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-292]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+796]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-292]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-280]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-280]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	mov       word ptr [ebp-380],488
	lea       eax,dword ptr [ebp-276]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-276]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@DesenhaTrapezio$qqrsssss
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-292]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-288]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-284]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-280]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-276]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 120
	mov       word ptr [ebp-380],500
	mov       edx,offset s@+179
	lea       eax,dword ptr [ebp-296]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-296]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 121
	mov       byte ptr [ebp-405],1
	?debug L 122
	jmp       @26
	?debug L 124
@18:
	push      637
	mov       word ptr [ebp-380],512
	lea       eax,dword ptr [ebp-300]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-300]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-300]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 125
	push      477
	mov       word ptr [ebp-380],524
	lea       eax,dword ptr [ebp-304]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-304]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	xor       ecx,ecx
	mov       eax,dword ptr [ebp-400]
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-304]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 126
	push      639
	lea       eax,dword ptr [ebp-312]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-312]
	call      @@System@AnsiString@ToInt$xqqrv
	add       eax,2
	push      eax
	mov       word ptr [ebp-380],536
	lea       eax,dword ptr [ebp-308]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-308]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-312]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-308]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 127
	push      479
	lea       eax,dword ptr [ebp-320]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-320]
	call      @@System@AnsiString@ToInt$xqqrv
	add       eax,2
	push      eax
	mov       word ptr [ebp-380],548
	lea       eax,dword ptr [ebp-316]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-316]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-320]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-316]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 128
	lea       eax,dword ptr [ebp-332]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-332]
	call      @@System@AnsiString@ToInt$xqqrv
	dec       eax
	push      eax
	lea       eax,dword ptr [ebp-328]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-328]
	call      @@System@AnsiString@ToInt$xqqrv
	inc       eax
	push      eax
	mov       word ptr [ebp-380],560
	lea       eax,dword ptr [ebp-324]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+796]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-324]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@ValidaNumero$qqriii
	test      al,al
	sete      dl
	and       edx,1
	push      edx
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-332]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-328]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-324]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	pop       ecx
	test      cl,cl
	jne       @26
	?debug L 130
	lea       eax,dword ptr [ebp-344]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+760]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-344]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-348]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+764]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-348]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-352]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+796]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-352]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	lea       eax,dword ptr [ebp-340]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+772]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-340]
	call      @@System@AnsiString@ToInt$xqqrv
	push      eax
	mov       word ptr [ebp-380],572
	lea       eax,dword ptr [ebp-336]
	call      @@System@AnsiString@$bctr$qqrv
	mov       edx,eax
	inc       dword ptr [ebp-368]
	mov       ecx,dword ptr [ebp-400]
	mov       eax,dword ptr [ecx+768]
	call      @@Controls@TControl@GetText$qqrv
	lea       eax,dword ptr [ebp-336]
	call      @@System@AnsiString@ToInt$xqqrv
	mov       edx,eax
	mov       eax,dword ptr [ebp-400]
	pop       ecx
	call      @@TForm1@DesenhaDivisa$qqrsssss
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-352]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-348]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-344]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-340]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-336]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 131
	mov       word ptr [ebp-380],584
	mov       edx,offset s@+196
	lea       eax,dword ptr [ebp-356]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-356]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 132
	mov       byte ptr [ebp-405],1
	?debug L 133
	?debug L 135
@16:
@26:
	cmp       byte ptr [ebp-405],0
	jne       short @54
	?debug L 136
	mov       word ptr [ebp-380],596
	mov       edx,offset s@+213
	lea       eax,dword ptr [ebp-360]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-368]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-400]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-368]
	lea       eax,dword ptr [ebp-360]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 138
@54:
	mov       byte ptr [ebp-405],0
	?debug L 139
	mov       ecx,dword ptr [ebp-396]
	mov       dword ptr fs:[0],ecx
	?debug L 139
@55:
	pop       ebx
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@TForm1@DesenhaClick$qqrp14System@TObject	endp
@TForm1@DesenhaClick$qqrp14System@TObject	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	88
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch15
	dd	?patch16
	dd	?patch17
	df	@@TForm1@DesenhaClick$qqrp14System@TObject
	dw	0
	dw	4345
	dw	0
	dw	176
	dw	0
	dw	0
	dw	0
	db	41
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	68
	db	101
	db	115
	db	101
	db	110
	db	104
	db	97
	db	67
	db	108
	db	105
	db	99
	db	107
	db	36
	db	113
	db	113
	db	114
	db	112
	db	49
	db	52
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	84
	db	79
	db	98
	db	106
	db	101
	db	99
	db	116
	dw	18
	dw	512
	dw	65136
	dw	65535
	dw	4291
	dw	0
	dw	177
	dw	0
	dw	0
	dw	0
	dw	?patch18
	dw	529
	dw	?patch19
	dd	?live16396@0-@@TForm1@DesenhaClick$qqrp14System@TObject
	dd	?live16396@0-?live16396@0
	dw	17
?patch19	equ	1
?patch18	equ	14
	dw	18
	dw	512
	dw	65132
	dw	65535
	dw	65528
	dw	65535
	dw	178
	dw	0
	dw	0
	dw	0
	dw	?patch20
	dw	529
	dw	?patch21
	dd	?live16396@0-@@TForm1@DesenhaClick$qqrp14System@TObject
	dd	?live16396@0-?live16396@0
	dw	19
?patch21	equ	1
?patch20	equ	14
	dw	18
	dw	512
	dw	65131
	dw	65535
	dw	48
	dw	0
	dw	179
	dw	0
	dw	0
	dw	0
?patch15	equ	@55-@@TForm1@DesenhaClick$qqrp14System@TObject+5
?patch16	equ	0
?patch17	equ	@55-@@TForm1@DesenhaClick$qqrp14System@TObject
	dw	2
	dw	6
	dw	8
	dw	531
	dw	1
	dw	65124
	dw	65535
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject	segment virtual
	align	2
@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject	label	dword
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-4
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-8
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-12
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-16
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-20
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-24
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-28
	dd	0
@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTKE$@TForm1@FiguraChange$qqrp14System@TObject	segment virtual
	align	2
@@_$ECTKE$@TForm1@FiguraChange$qqrp14System@TObject	label	dword
	dd	0
	dd	-64
	dw	0
	dw	5
	dd	0
	dd	@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject
	dw	0
	dw	5
	dd	0
	dd	@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject+16
	dw	0
	dw	5
	dd	0
	dd	@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject+32
	dw	0
	dw	5
	dd	0
	dd	@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject+48
	dw	0
	dw	5
	dd	0
	dd	@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject+64
	dw	0
	dw	5
	dd	0
	dd	@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject+80
	dw	0
	dw	5
	dd	0
	dd	@@_$DCJE$@TForm1@FiguraChange$qqrp14System@TObject+96
@_$ECTKE$@TForm1@FiguraChange$qqrp14System@TObject	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@FiguraChange$qqrp14System@TObject	segment virtual
@@TForm1@FiguraChange$qqrp14System@TObject	proc	near
?live16401@0:
	?debug L 141
	push      ebp
	mov       ebp,esp
	add       esp,-72
	mov       dword ptr [ebp-72],edx
	mov       dword ptr [ebp-68],eax
@56:
	mov       eax,offset @@_$ECTKE$@TForm1@FiguraChange$qqrp14System@TObject
	call      @__InitExceptBlockLDTC
	?debug L 143
	mov       edx,dword ptr [ebp-68]
	mov       eax,dword ptr [edx+732]
	call      @@Stdctrls@TCustomComboBox@GetItemIndex$qqrv
	cmp       eax,5
	ja        @57
	jmp       dword ptr [@65+4*eax]
@65:
	dd        @64
	dd        @63
	dd        @62
	dd        @61
	dd        @60
	dd        @59
	?debug L 145
@64:
	xor       edx,edx
	mov       ecx,dword ptr [ebp-68]
	mov       eax,dword ptr [ecx+788]
	call      @@Controls@TControl@SetVisible$qqro
	?debug L 146
	mov       word ptr [ebp-48],8
	mov       edx,offset s@+252
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       ecx,dword ptr [ebp-68]
	mov       eax,dword ptr [ecx+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-4]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 147
	jmp       @66
	?debug L 149
@63:
	mov       word ptr [ebp-48],20
	mov       edx,offset s@+327
	lea       eax,dword ptr [ebp-8]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       eax,dword ptr [ebp-68]
	mov       eax,dword ptr [eax+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-8]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 150
	xor       edx,edx
	mov       eax,dword ptr [ebp-68]
	mov       eax,dword ptr [eax+788]
	call      @@Controls@TControl@SetVisible$qqro
	?debug L 151
	jmp       @66
	?debug L 153
@62:
	mov       word ptr [ebp-48],32
	mov       edx,offset s@+371
	lea       eax,dword ptr [ebp-12]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       ecx,dword ptr [ebp-68]
	mov       eax,dword ptr [ecx+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-12]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 154
	xor       edx,edx
	mov       eax,dword ptr [ebp-68]
	mov       eax,dword ptr [eax+788]
	call      @@Controls@TControl@SetVisible$qqro
	?debug L 155
	jmp       @66
	?debug L 157
@61:
	mov       word ptr [ebp-48],44
	mov       edx,offset s@+416
	lea       eax,dword ptr [ebp-16]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       ecx,dword ptr [ebp-68]
	mov       eax,dword ptr [ecx+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-16]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 158
	mov       dl,1
	mov       eax,dword ptr [ebp-68]
	mov       eax,dword ptr [eax+788]
	call      @@Controls@TControl@SetVisible$qqro
	?debug L 159
	jmp       @66
	?debug L 161
@60:
	mov       word ptr [ebp-48],56
	mov       edx,offset s@+511
	lea       eax,dword ptr [ebp-20]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       ecx,dword ptr [ebp-68]
	mov       eax,dword ptr [ecx+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-20]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 162
	mov       dl,1
	mov       eax,dword ptr [ebp-68]
	mov       eax,dword ptr [eax+788]
	call      @@Controls@TControl@SetVisible$qqro
	?debug L 163
	jmp       @66
	?debug L 165
@59:
	mov       word ptr [ebp-48],68
	mov       edx,offset s@+606
	lea       eax,dword ptr [ebp-24]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       ecx,dword ptr [ebp-68]
	mov       eax,dword ptr [ecx+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-24]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 166
	mov       dl,1
	mov       eax,dword ptr [ebp-68]
	mov       eax,dword ptr [eax+788]
	call      @@Controls@TControl@SetVisible$qqro
	?debug L 167
	jmp       short @66
	?debug L 169
@57:
	mov       word ptr [ebp-48],80
	mov       edx,offset s@+691
	lea       eax,dword ptr [ebp-28]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-36]
	mov       edx,dword ptr [eax]
	mov       ecx,dword ptr [ebp-68]
	mov       eax,dword ptr [ecx+804]
	call      @@Controls@TControl@SetText$qqrx17System@AnsiString
	dec       dword ptr [ebp-36]
	lea       eax,dword ptr [ebp-28]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 170
	xor       edx,edx
	mov       eax,dword ptr [ebp-68]
	mov       eax,dword ptr [eax+788]
	call      @@Controls@TControl@SetVisible$qqro
	?debug L 171
	?debug L 173
@66:
	mov       edx,dword ptr [ebp-64]
	mov       dword ptr fs:[0],edx
	?debug L 173
@67:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@TForm1@FiguraChange$qqrp14System@TObject	endp
@TForm1@FiguraChange$qqrp14System@TObject	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	88
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch22
	dd	?patch23
	dd	?patch24
	df	@@TForm1@FiguraChange$qqrp14System@TObject
	dw	0
	dw	4347
	dw	0
	dw	180
	dw	0
	dw	0
	dw	0
	db	41
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	70
	db	105
	db	103
	db	117
	db	114
	db	97
	db	67
	db	104
	db	97
	db	110
	db	103
	db	101
	db	36
	db	113
	db	113
	db	114
	db	112
	db	49
	db	52
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	84
	db	79
	db	98
	db	106
	db	101
	db	99
	db	116
	dw	18
	dw	512
	dw	65468
	dw	65535
	dw	4291
	dw	0
	dw	181
	dw	0
	dw	0
	dw	0
	dw	?patch25
	dw	529
	dw	?patch26
	dd	?live16401@0-@@TForm1@FiguraChange$qqrp14System@TObject
	dd	?live16401@0-?live16401@0
	dw	17
?patch26	equ	1
?patch25	equ	14
	dw	18
	dw	512
	dw	65464
	dw	65535
	dw	65528
	dw	65535
	dw	182
	dw	0
	dw	0
	dw	0
	dw	?patch27
	dw	529
	dw	?patch28
	dd	?live16401@0-@@TForm1@FiguraChange$qqrp14System@TObject
	dd	?live16401@0-?live16401@0
	dw	19
?patch28	equ	1
?patch27	equ	14
?patch22	equ	@67-@@TForm1@FiguraChange$qqrp14System@TObject+4
?patch23	equ	0
?patch24	equ	@67-@@TForm1@FiguraChange$qqrp14System@TObject
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCLE$@TForm1@ApagaImagem$qqrv	segment virtual
	align	2
@@_$DCLE$@TForm1@ApagaImagem$qqrv	label	dword
	dd	@@$xt$p13Windows@TRect
	dd	8199
	dd	-4
	dd	0
@_$DCLE$@TForm1@ApagaImagem$qqrv	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTME$@TForm1@ApagaImagem$qqrv	segment virtual
	align	2
@@_$ECTME$@TForm1@ApagaImagem$qqrv	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	0
	dw	8
	dw	5
	dd	0
	dd	@@_$DCLE$@TForm1@ApagaImagem$qqrv
@_$ECTME$@TForm1@ApagaImagem$qqrv	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@ApagaImagem$qqrv	segment virtual
@@TForm1@ApagaImagem$qqrv	proc	near
?live16404@0:
	?debug L 175
	push      ebp
	mov       ebp,esp
	add       esp,-48
	mov       dword ptr [ebp-44],eax
@68:
	mov       eax,offset @@_$ECTME$@TForm1@ApagaImagem$qqrv
	call      @__InitExceptBlockLDTC
	?debug L 177
	mov       edx,dword ptr [ebp-44]
	mov       eax,dword ptr [edx+780]
	mov       edx,dword ptr [eax]
	call      dword ptr [edx+180]
	test      al,al
	jne       short @69
	?debug L 178
@70:
	push      16
	call      @$bnew$qui
	pop       ecx
	mov       dword ptr [ebp-4],eax
	test      eax,eax
	je        short @71
	mov       word ptr [ebp-24],20
	mov       edx,dword ptr [ebp-44]
	mov       ecx,dword ptr [edx+720]
	push      dword ptr [ecx+60]
	mov       eax,dword ptr [ebp-44]
	mov       edx,dword ptr [eax+720]
	push      dword ptr [edx+56]
	push      0
	push      0
	push      dword ptr [ebp-4]
	call      @@Windows@TRect@$bctr$qiiii
	add       esp,20
	mov       word ptr [ebp-24],8
	mov       ecx,dword ptr [ebp-4]
	jmp       short @72
@71:
	mov       ecx,dword ptr [ebp-4]
@72:
	mov       dword ptr [ebp-48],ecx
	?debug L 179
	mov       eax,dword ptr [ebp-44]
	mov       eax,dword ptr [eax+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       edx,dword ptr [ebp-48]
	call      @@Graphics@TCanvas@FillRect$qqrrx13Windows@TRect
	?debug L 180
	push      dword ptr [ebp-48]
	call      @$bdele$qpv
	pop       ecx
	?debug L 182
@73:
@69:
	mov       ecx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],ecx
	?debug L 182
@74:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@TForm1@ApagaImagem$qqrv	endp
@TForm1@ApagaImagem$qqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	71
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch29
	dd	?patch30
	dd	?patch31
	df	@@TForm1@ApagaImagem$qqrv
	dw	0
	dw	4349
	dw	0
	dw	183
	dw	0
	dw	0
	dw	0
	db	24
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	65
	db	112
	db	97
	db	103
	db	97
	db	73
	db	109
	db	97
	db	103
	db	101
	db	109
	db	36
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65492
	dw	65535
	dw	4291
	dw	0
	dw	184
	dw	0
	dw	0
	dw	0
	dw	?patch32
	dw	529
	dw	?patch33
	dd	?live16404@0-@@TForm1@ApagaImagem$qqrv
	dd	?live16404@0-?live16404@0
	dw	17
?patch33	equ	1
?patch32	equ	14
	dw	24
	dw	519
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch34
	df	@70
	dw	0
	dw	0
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	65510
	dw	65535
	dw	185
	dw	0
	dw	0
	dw	0
?patch34	equ	@73-@70
	dw	2
	dw	6
?patch29	equ	@74-@@TForm1@ApagaImagem$qqrv+4
?patch30	equ	0
?patch31	equ	@74-@@TForm1@ApagaImagem$qqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@ValidaNumero$qqriii	segment virtual
@@TForm1@ValidaNumero$qqriii	proc	near
?live16407@0:
	?debug L 184
	push      ebp
	mov       ebp,esp
	add       esp,-12
	mov       dword ptr [ebp-12],ecx
	mov       dword ptr [ebp-8],edx
	mov       dword ptr [ebp-4],eax
	?debug L 186
@75:
	mov       eax,dword ptr [ebp-8]
	cmp       eax,dword ptr [ebp-12]
	jl        short @77
	mov       edx,dword ptr [ebp-8]
	cmp       edx,dword ptr [ebp+8]
	jle       short @76
	?debug L 187
@77:
	xor       eax,eax
	jmp       short @78
	?debug L 189
@76:
	mov       al,1
	?debug L 190
@80:
@78:
	mov       esp,ebp
	pop       ebp
	ret       4
	?debug L 0
@@TForm1@ValidaNumero$qqriii	endp
@TForm1@ValidaNumero$qqriii	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	74
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch35
	dd	?patch36
	dd	?patch37
	df	@@TForm1@ValidaNumero$qqriii
	dw	0
	dw	4351
	dw	0
	dw	186
	dw	0
	dw	0
	dw	0
	db	27
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	86
	db	97
	db	108
	db	105
	db	100
	db	97
	db	78
	db	117
	db	109
	db	101
	db	114
	db	111
	db	36
	db	113
	db	113
	db	114
	db	105
	db	105
	db	105
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4291
	dw	0
	dw	187
	dw	0
	dw	0
	dw	0
	dw	?patch38
	dw	529
	dw	?patch39
	dd	?live16407@0-@@TForm1@ValidaNumero$qqriii
	dd	?live16407@0-?live16407@0
	dw	17
?patch39	equ	1
?patch38	equ	14
	dw	18
	dw	512
	dw	65528
	dw	65535
	dw	116
	dw	0
	dw	188
	dw	0
	dw	0
	dw	0
	dw	?patch40
	dw	529
	dw	?patch41
	dd	?live16407@0-@@TForm1@ValidaNumero$qqriii
	dd	?live16407@0-?live16407@0
	dw	19
?patch41	equ	1
?patch40	equ	14
	dw	18
	dw	512
	dw	65524
	dw	65535
	dw	116
	dw	0
	dw	189
	dw	0
	dw	0
	dw	0
	dw	?patch42
	dw	529
	dw	?patch43
	dd	?live16407@0-@@TForm1@ValidaNumero$qqriii
	dd	?live16407@0-?live16407@0
	dw	18
?patch43	equ	1
?patch42	equ	14
	dw	18
	dw	512
	dw	8
	dw	0
	dw	116
	dw	0
	dw	190
	dw	0
	dw	0
	dw	0
?patch35	equ	@80-@@TForm1@ValidaNumero$qqriii+6
?patch36	equ	0
?patch37	equ	@80-@@TForm1@ValidaNumero$qqriii
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@DesenhaRectangulo$qqrssss	segment virtual
@@TForm1@DesenhaRectangulo$qqrssss	proc	near
?live16408@0:
	?debug L 197
	push      ebp
	mov       ebp,esp
	add       esp,-12
	push      ebx
	push      esi
	push      edi
	mov       word ptr [ebp-8],cx
	mov       word ptr [ebp-6],dx
	mov       dword ptr [ebp-4],eax
	?debug L 199
@81:
	mov       eax,dword ptr [ebp-4]
	mov       eax,dword ptr [eax+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       dword ptr [ebp-12],eax
	?debug L 204
	mov	 dx, word ptr [ebp-6]    
	?debug L 205
	mov	 cx, 479
	?debug L 206
	sub	 cx, word ptr [ebp-8]   
	?debug L 207
@82:
ciclo_rect1:
	?debug L 208
	push	 cx 
	?debug L 209
	push	 dx 
	?debug L 211
	push	      255                   
	?debug L 212
	movzx	     ecx,cx                  
	?debug L 213
	movzx	     edx,dx                  
	?debug L 214
	mov	       eax,dword ptr [ebp-12]  
	?debug L 215
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 216
	pop	 dx 
	?debug L 217
	pop	 cx 
	?debug L 219
	inc	 dx
	?debug L 220
	cmp	 dx, word ptr [ebp+12]
	?debug L 221
	jbe       @82
	?debug L 225
	mov	 dx, word ptr [ebp-6]    
	?debug L 226
	mov	 cx, 479
	?debug L 227
	sub	 cx, word ptr [ebp+8]   
	?debug L 228
@83:
ciclo_rect2:
	?debug L 229
	push	 cx 
	?debug L 230
	push	 dx 
	?debug L 232
	push	      255                   
	?debug L 233
	movzx	     ecx,cx                  
	?debug L 234
	movzx	     edx,dx                  
	?debug L 235
	mov	       eax,dword ptr [ebp-12]  
	?debug L 236
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 237
	pop	 dx 
	?debug L 238
	pop	 cx 
	?debug L 240
	inc	 dx
	?debug L 241
	cmp	 dx, word ptr [ebp+12]
	?debug L 242
	jbe       @83
	?debug L 246
	mov	 dx, word ptr [ebp-6]    
	?debug L 247
	mov	 cx, 479
	?debug L 248
	sub	 cx, word ptr [ebp+8]   
	?debug L 249
	mov	 bx, 479
	?debug L 250
	sub	 bx, word ptr [ebp-8]   
	?debug L 251
@84:
ciclo_rect3:
	?debug L 252
	push	 cx 
	?debug L 253
	push	 dx 
	?debug L 255
	push	      255                   
	?debug L 256
	movzx	     ecx,cx                  
	?debug L 257
	movzx	     edx,dx                  
	?debug L 258
	mov	       eax,dword ptr [ebp-12]  
	?debug L 259
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 260
	pop	 dx 
	?debug L 261
	pop	 cx 
	?debug L 263
	inc	 cx
	?debug L 264
	cmp	 cx, bx
	?debug L 265
	jbe       @84
	?debug L 269
	mov	 dx, word ptr [ebp+12]    
	?debug L 270
	mov	 cx, 479
	?debug L 271
	sub	 cx, word ptr [ebp+8]   
	?debug L 272
	mov	 bx, 479
	?debug L 273
	sub	 bx, word ptr [ebp-8]   
	?debug L 274
@85:
ciclo_rect4:
	?debug L 275
	push	 cx 
	?debug L 276
	push	 dx 
	?debug L 278
	push	      255                   
	?debug L 279
	movzx	     ecx,cx                  
	?debug L 280
	movzx	     edx,dx                  
	?debug L 281
	mov	       eax,dword ptr [ebp-12]  
	?debug L 282
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 283
	pop	 dx 
	?debug L 284
	pop	 cx 
	?debug L 286
	inc	 cx
	?debug L 287
	cmp	 cx, bx
	?debug L 288
	jbe       @85
	?debug L 291
	push      0
	movsx     edx,word ptr [ebp-8]
	mov       ecx,479
	sub       ecx,edx
	movsx     edx,word ptr [ebp-6]
	mov       eax,dword ptr [ebp-12]
	call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 292
	push      0
	movsx     ecx,word ptr [ebp+8]
	push      ecx
	mov       ecx,479
	pop       eax
	sub       ecx,eax
	movsx     edx,word ptr [ebp+12]
	mov       eax,dword ptr [ebp-12]
	call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 294
@86:
	pop       edi
	pop       esi
	pop       ebx
	mov       esp,ebp
	pop       ebp
	ret       8
	?debug L 0
@@TForm1@DesenhaRectangulo$qqrssss	endp
@TForm1@DesenhaRectangulo$qqrssss	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	80
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch44
	dd	?patch45
	dd	?patch46
	df	@@TForm1@DesenhaRectangulo$qqrssss
	dw	0
	dw	4353
	dw	0
	dw	191
	dw	0
	dw	0
	dw	0
	db	33
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	68
	db	101
	db	115
	db	101
	db	110
	db	104
	db	97
	db	82
	db	101
	db	99
	db	116
	db	97
	db	110
	db	103
	db	117
	db	108
	db	111
	db	36
	db	113
	db	113
	db	114
	db	115
	db	115
	db	115
	db	115
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4291
	dw	0
	dw	192
	dw	0
	dw	0
	dw	0
	dw	?patch47
	dw	529
	dw	?patch48
	dd	?live16408@0-@@TForm1@DesenhaRectangulo$qqrssss
	dd	?live16408@0-?live16408@0
	dw	17
?patch48	equ	1
?patch47	equ	14
	dw	18
	dw	512
	dw	65530
	dw	65535
	dw	17
	dw	0
	dw	193
	dw	0
	dw	0
	dw	0
	dw	?patch49
	dw	529
	dw	?patch50
	dd	?live16408@0-@@TForm1@DesenhaRectangulo$qqrssss
	dd	?live16408@0-?live16408@0
	dw	11
?patch50	equ	1
?patch49	equ	14
	dw	18
	dw	512
	dw	65528
	dw	65535
	dw	17
	dw	0
	dw	194
	dw	0
	dw	0
	dw	0
	dw	?patch51
	dw	529
	dw	?patch52
	dd	?live16408@0-@@TForm1@DesenhaRectangulo$qqrssss
	dd	?live16408@0-?live16408@0
	dw	10
?patch52	equ	1
?patch51	equ	14
	dw	18
	dw	512
	dw	12
	dw	0
	dw	17
	dw	0
	dw	195
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	8
	dw	0
	dw	17
	dw	0
	dw	196
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	65524
	dw	65535
	dw	65531
	dw	65535
	dw	197
	dw	0
	dw	0
	dw	0
?patch44	equ	@86-@@TForm1@DesenhaRectangulo$qqrssss+9
?patch45	equ	0
?patch46	equ	@86-@@TForm1@DesenhaRectangulo$qqrssss
	dw	2
	dw	6
	dw	8
	dw	531
	dw	7
	dw	65512
	dw	65535
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCNE$@TForm1@DesenhaTriangulo$qqrssss	segment virtual
	align	2
@@_$DCNE$@TForm1@DesenhaTriangulo$qqrssss	label	dword
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-4
	dd	0
@_$DCNE$@TForm1@DesenhaTriangulo$qqrssss	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTOE$@TForm1@DesenhaTriangulo$qqrssss	segment virtual
	align	2
@@_$ECTOE$@TForm1@DesenhaTriangulo$qqrssss	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCNE$@TForm1@DesenhaTriangulo$qqrssss
@_$ECTOE$@TForm1@DesenhaTriangulo$qqrssss	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@DesenhaTriangulo$qqrssss	segment virtual
@@TForm1@DesenhaTriangulo$qqrssss	proc	near
?live16409@0:
	?debug L 298
	push      ebp
	mov       ebp,esp
	add       esp,-52
	mov       word ptr [ebp-48],cx
	mov       word ptr [ebp-46],dx
	mov       dword ptr [ebp-44],eax
@87:
	mov       eax,offset @@_$ECTOE$@TForm1@DesenhaTriangulo$qqrssss
	call      @__InitExceptBlockLDTC
	?debug L 300
	mov       edx,dword ptr [ebp-44]
	mov       eax,dword ptr [edx+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       dword ptr [ebp-52],eax
	?debug L 302
	mov       eax,dword ptr [ebp-44]
	call      @@TForm1@ApagaImagem$qqrv
	?debug L 303
	mov       word ptr [ebp-24],8
	mov       edx,offset s@+692
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-12]
	push      dword ptr [eax]
	mov       ecx,130
	mov       edx,230
	mov       eax,dword ptr [ebp-52]
	call      @@Graphics@TCanvas@TextOutA$qqriix17System@AnsiString
	dec       dword ptr [ebp-12]
	lea       eax,dword ptr [ebp-4]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 305
	mov       ecx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],ecx
	?debug L 305
@88:
	mov       esp,ebp
	pop       ebp
	ret       8
	?debug L 0
@@TForm1@DesenhaTriangulo$qqrssss	endp
@TForm1@DesenhaTriangulo$qqrssss	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	79
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch53
	dd	?patch54
	dd	?patch55
	df	@@TForm1@DesenhaTriangulo$qqrssss
	dw	0
	dw	4355
	dw	0
	dw	198
	dw	0
	dw	0
	dw	0
	db	32
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	68
	db	101
	db	115
	db	101
	db	110
	db	104
	db	97
	db	84
	db	114
	db	105
	db	97
	db	110
	db	103
	db	117
	db	108
	db	111
	db	36
	db	113
	db	113
	db	114
	db	115
	db	115
	db	115
	db	115
	dw	18
	dw	512
	dw	65492
	dw	65535
	dw	4291
	dw	0
	dw	199
	dw	0
	dw	0
	dw	0
	dw	?patch56
	dw	529
	dw	?patch57
	dd	?live16409@0-@@TForm1@DesenhaTriangulo$qqrssss
	dd	?live16409@0-?live16409@0
	dw	17
?patch57	equ	1
?patch56	equ	14
	dw	18
	dw	512
	dw	65490
	dw	65535
	dw	17
	dw	0
	dw	200
	dw	0
	dw	0
	dw	0
	dw	?patch58
	dw	529
	dw	?patch59
	dd	?live16409@0-@@TForm1@DesenhaTriangulo$qqrssss
	dd	?live16409@0-?live16409@0
	dw	11
?patch59	equ	1
?patch58	equ	14
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	17
	dw	0
	dw	201
	dw	0
	dw	0
	dw	0
	dw	?patch60
	dw	529
	dw	?patch61
	dd	?live16409@0-@@TForm1@DesenhaTriangulo$qqrssss
	dd	?live16409@0-?live16409@0
	dw	10
?patch61	equ	1
?patch60	equ	14
	dw	18
	dw	512
	dw	12
	dw	0
	dw	17
	dw	0
	dw	202
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	8
	dw	0
	dw	17
	dw	0
	dw	203
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	65484
	dw	65535
	dw	65531
	dw	65535
	dw	204
	dw	0
	dw	0
	dw	0
?patch53	equ	@88-@@TForm1@DesenhaTriangulo$qqrssss+6
?patch54	equ	0
?patch55	equ	@88-@@TForm1@DesenhaTriangulo$qqrssss
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCPE$@TForm1@DesenhaLosango$qqrssss	segment virtual
	align	2
@@_$DCPE$@TForm1@DesenhaLosango$qqrssss	label	dword
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-4
	dd	0
@_$DCPE$@TForm1@DesenhaLosango$qqrssss	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTQE$@TForm1@DesenhaLosango$qqrssss	segment virtual
	align	2
@@_$ECTQE$@TForm1@DesenhaLosango$qqrssss	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCPE$@TForm1@DesenhaLosango$qqrssss
@_$ECTQE$@TForm1@DesenhaLosango$qqrssss	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@DesenhaLosango$qqrssss	segment virtual
@@TForm1@DesenhaLosango$qqrssss	proc	near
?live16412@0:
	?debug L 309
	push      ebp
	mov       ebp,esp
	add       esp,-52
	mov       word ptr [ebp-48],cx
	mov       word ptr [ebp-46],dx
	mov       dword ptr [ebp-44],eax
@89:
	mov       eax,offset @@_$ECTQE$@TForm1@DesenhaLosango$qqrssss
	call      @__InitExceptBlockLDTC
	?debug L 311
	mov       edx,dword ptr [ebp-44]
	mov       eax,dword ptr [edx+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       dword ptr [ebp-52],eax
	?debug L 313
	mov       eax,dword ptr [ebp-44]
	call      @@TForm1@ApagaImagem$qqrv
	?debug L 314
	mov       word ptr [ebp-24],8
	mov       edx,offset s@+715
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-12]
	push      dword ptr [eax]
	mov       ecx,150
	mov       edx,230
	mov       eax,dword ptr [ebp-52]
	call      @@Graphics@TCanvas@TextOutA$qqriix17System@AnsiString
	dec       dword ptr [ebp-12]
	lea       eax,dword ptr [ebp-4]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 316
	mov       ecx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],ecx
	?debug L 316
@90:
	mov       esp,ebp
	pop       ebp
	ret       8
	?debug L 0
@@TForm1@DesenhaLosango$qqrssss	endp
@TForm1@DesenhaLosango$qqrssss	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	77
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch62
	dd	?patch63
	dd	?patch64
	df	@@TForm1@DesenhaLosango$qqrssss
	dw	0
	dw	4357
	dw	0
	dw	205
	dw	0
	dw	0
	dw	0
	db	30
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	68
	db	101
	db	115
	db	101
	db	110
	db	104
	db	97
	db	76
	db	111
	db	115
	db	97
	db	110
	db	103
	db	111
	db	36
	db	113
	db	113
	db	114
	db	115
	db	115
	db	115
	db	115
	dw	18
	dw	512
	dw	65492
	dw	65535
	dw	4291
	dw	0
	dw	206
	dw	0
	dw	0
	dw	0
	dw	?patch65
	dw	529
	dw	?patch66
	dd	?live16412@0-@@TForm1@DesenhaLosango$qqrssss
	dd	?live16412@0-?live16412@0
	dw	17
?patch66	equ	1
?patch65	equ	14
	dw	18
	dw	512
	dw	65490
	dw	65535
	dw	17
	dw	0
	dw	207
	dw	0
	dw	0
	dw	0
	dw	?patch67
	dw	529
	dw	?patch68
	dd	?live16412@0-@@TForm1@DesenhaLosango$qqrssss
	dd	?live16412@0-?live16412@0
	dw	11
?patch68	equ	1
?patch67	equ	14
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	17
	dw	0
	dw	208
	dw	0
	dw	0
	dw	0
	dw	?patch69
	dw	529
	dw	?patch70
	dd	?live16412@0-@@TForm1@DesenhaLosango$qqrssss
	dd	?live16412@0-?live16412@0
	dw	10
?patch70	equ	1
?patch69	equ	14
	dw	18
	dw	512
	dw	12
	dw	0
	dw	17
	dw	0
	dw	209
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	8
	dw	0
	dw	17
	dw	0
	dw	210
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	65484
	dw	65535
	dw	65531
	dw	65535
	dw	211
	dw	0
	dw	0
	dw	0
?patch62	equ	@90-@@TForm1@DesenhaLosango$qqrssss+6
?patch63	equ	0
?patch64	equ	@90-@@TForm1@DesenhaLosango$qqrssss
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@DesenhaParalelogramo$qqrsssss	segment virtual
@@TForm1@DesenhaParalelogramo$qqrsssss	proc	near
?live16415@0:
	?debug L 320
	push      ebp
	mov       ebp,esp
	add       esp,-12
	push      ebx
	push      esi
	push      edi
	mov       word ptr [ebp-8],cx
	mov       word ptr [ebp-6],dx
	mov       dword ptr [ebp-4],eax
	?debug L 322
@91:
	mov       eax,dword ptr [ebp-4]
	mov       eax,dword ptr [eax+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       dword ptr [ebp-12],eax
	?debug L 330
	mov	 cx,479
	?debug L 331
	sub	 cx,word ptr [ebp-8]
	?debug L 332
	mov	 bx,479
	?debug L 333
	sub	 bx,word ptr [ebp+12]
	?debug L 334
	mov	 si,word ptr [ebp+8]
	?debug L 335
	mov	 dx,word ptr [ebp-6]
	?debug L 336
	mov	 ax,word ptr [ebp+16]
	?debug L 337
@92:
CICLO_RET:
	?debug L 339
	push	 ax
	?debug L 340
	push	 cx
	?debug L 341
	push	 dx
	?debug L 342
	push	      16711680
	?debug L 343
	movzx	     ecx,cx
	?debug L 344
	movzx	     edx,dx
	?debug L 345
	mov	       eax,dword ptr [ebp-12]
	?debug L 346
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 354
	push	      16711680
	?debug L 355
	movzx	     ecx,bx
	?debug L 356
	movzx	     edx,si
	?debug L 357
	mov	       eax,dword ptr [ebp-12]
	?debug L 358
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 359
	pop	 dx
	?debug L 360
	pop	 cx
	?debug L 361
	pop	 ax
	?debug L 363
	inc	 si
	?debug L 364
	inc	 dx
	?debug L 366
	cmp	 ax,si
	?debug L 367
	jne       short @92
	?debug L 374
	mov	 ax,479
	?debug L 375
	sub	 ax,word ptr [ebp-8]
	?debug L 376
	push	 ax
	?debug L 378
	mov	 cx,479
	?debug L 379
	sub	 cx,word ptr [ebp+12]     
	?debug L 380
	mov	 si,word ptr [ebp+8]
	?debug L 381
	sub	 si,word ptr [ebp-6]     
	?debug L 382
	mov	 di,word ptr [ebp+12]
	?debug L 383
	sub	 di,word ptr [ebp-8]     
	?debug L 384
	mov	 dx,word ptr [ebp+8]     
	?debug L 385
	mov	 bx,word ptr [ebp+16]
	?debug L 387
	cmp	 si,di
	?debug L 388
	jbe       short @93
	?debug L 389
	mov	 ax,di
	?debug L 390
	add	 ax,di
	?debug L 391
	sub	 ax,si
	?debug L 392
@94:
CICLO_DIAG_D1:
	?debug L 394
	push	 ax
	?debug L 395
	push	 dx
	?debug L 396
	push	 cx
	?debug L 397
	push	      16711680
	?debug L 398
	movzx	     ecx,cx
	?debug L 399
	movzx	     edx,dx
	?debug L 400
	mov	       eax,dword ptr [ebp-12]
	?debug L 401
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 402
	pop	 cx
	?debug L 408
	push	 cx
	?debug L 409
	push	      16711680
	?debug L 410
	movzx	     ecx,cx
	?debug L 411
	movzx	     edx,bx
	?debug L 412
	mov	       eax,dword ptr [ebp-12]
	?debug L 413
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 414
	pop	 cx
	?debug L 415
	pop	 dx
	?debug L 416
	pop	 ax
	?debug L 418
	cmp	 ax,0
	?debug L 419
	jle       short @95
	?debug L 420
	sub	 ax,si
	?debug L 421
	sub	 ax,si
	?debug L 422
	inc	 cx
	?debug L 424
@95:
MENOR_1:
	?debug L 425
	add	 ax,di
	?debug L 426
	add	 ax,di
	?debug L 427
	dec	 dx
	?debug L 428
	dec	 bx
	?debug L 430
	cmp	 dx,word ptr [ebp-6]
	?debug L 431
	ja        short @94
	?debug L 432
	jmp       short @96
	?debug L 433
@93:
DECLIVE_1:
	?debug L 434
	mov	 ax,si
	?debug L 435
	add	 ax,si
	?debug L 436
	sub	 ax,di
	?debug L 438
@97:
CICLO_DIAG_D2:
	?debug L 440
	push	 ax
	?debug L 441
	push	 dx
	?debug L 442
	push	 cx
	?debug L 443
	push	      16711680
	?debug L 444
	movzx	     ecx,cx
	?debug L 445
	movzx	     edx,dx
	?debug L 446
	mov	       eax,dword ptr [ebp-12]
	?debug L 447
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 448
	pop	 cx
	?debug L 450
	push	 cx
	?debug L 451
	push	      16711680
	?debug L 452
	movzx	     ecx,cx
	?debug L 453
	movzx	     edx,bx
	?debug L 454
	mov	       eax,dword ptr [ebp-12]
	?debug L 455
	call	      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
	?debug L 456
	pop	 cx
	?debug L 457
	pop	 dx
	?debug L 458
	pop	 ax
	?debug L 460
	cmp	 ax,0
	?debug L 461
	jle       short @98
	?debug L 463
	sub	 ax,di
	?debug L 464
	sub	 ax,di
	?debug L 465
	dec	 dx
	?debug L 466
	dec	 bx
	?debug L 468
@98:
MENOR_2:
	?debug L 469
	add	 ax,si
	?debug L 470
	add	 ax,si
	?debug L 471
	inc	 cx
	?debug L 473
	cmp	 cx,word ptr[esp]
	?debug L 474
	jbe       short @97
	?debug L 475
@96:
FINAL:
	?debug L 477
	pop	 ax
	?debug L 480
@99:
	pop       edi
	pop       esi
	pop       ebx
	mov       esp,ebp
	pop       ebp
	ret       12
	?debug L 0
@@TForm1@DesenhaParalelogramo$qqrsssss	endp
@TForm1@DesenhaParalelogramo$qqrsssss	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	84
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch71
	dd	?patch72
	dd	?patch73
	df	@@TForm1@DesenhaParalelogramo$qqrsssss
	dw	0
	dw	4359
	dw	0
	dw	212
	dw	0
	dw	0
	dw	0
	db	37
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	68
	db	101
	db	115
	db	101
	db	110
	db	104
	db	97
	db	80
	db	97
	db	114
	db	97
	db	108
	db	101
	db	108
	db	111
	db	103
	db	114
	db	97
	db	109
	db	111
	db	36
	db	113
	db	113
	db	114
	db	115
	db	115
	db	115
	db	115
	db	115
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4291
	dw	0
	dw	213
	dw	0
	dw	0
	dw	0
	dw	?patch74
	dw	529
	dw	?patch75
	dd	?live16415@0-@@TForm1@DesenhaParalelogramo$qqrsssss
	dd	?live16415@0-?live16415@0
	dw	17
?patch75	equ	1
?patch74	equ	14
	dw	18
	dw	512
	dw	65530
	dw	65535
	dw	17
	dw	0
	dw	214
	dw	0
	dw	0
	dw	0
	dw	?patch76
	dw	529
	dw	?patch77
	dd	?live16415@0-@@TForm1@DesenhaParalelogramo$qqrsssss
	dd	?live16415@0-?live16415@0
	dw	11
?patch77	equ	1
?patch76	equ	14
	dw	18
	dw	512
	dw	65528
	dw	65535
	dw	17
	dw	0
	dw	215
	dw	0
	dw	0
	dw	0
	dw	?patch78
	dw	529
	dw	?patch79
	dd	?live16415@0-@@TForm1@DesenhaParalelogramo$qqrsssss
	dd	?live16415@0-?live16415@0
	dw	10
?patch79	equ	1
?patch78	equ	14
	dw	18
	dw	512
	dw	16
	dw	0
	dw	17
	dw	0
	dw	216
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	12
	dw	0
	dw	17
	dw	0
	dw	217
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	8
	dw	0
	dw	17
	dw	0
	dw	218
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	65524
	dw	65535
	dw	65531
	dw	65535
	dw	219
	dw	0
	dw	0
	dw	0
?patch71	equ	@99-@@TForm1@DesenhaParalelogramo$qqrsssss+9
?patch72	equ	0
?patch73	equ	@99-@@TForm1@DesenhaParalelogramo$qqrsssss
	dw	2
	dw	6
	dw	8
	dw	531
	dw	7
	dw	65512
	dw	65535
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCRE$@TForm1@DesenhaTrapezio$qqrsssss	segment virtual
	align	2
@@_$DCRE$@TForm1@DesenhaTrapezio$qqrsssss	label	dword
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-4
	dd	0
@_$DCRE$@TForm1@DesenhaTrapezio$qqrsssss	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTSE$@TForm1@DesenhaTrapezio$qqrsssss	segment virtual
	align	2
@@_$ECTSE$@TForm1@DesenhaTrapezio$qqrsssss	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCRE$@TForm1@DesenhaTrapezio$qqrsssss
@_$ECTSE$@TForm1@DesenhaTrapezio$qqrsssss	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@DesenhaTrapezio$qqrsssss	segment virtual
@@TForm1@DesenhaTrapezio$qqrsssss	proc	near
?live16416@0:
	?debug L 484
	push      ebp
	mov       ebp,esp
	add       esp,-52
	mov       word ptr [ebp-48],cx
	mov       word ptr [ebp-46],dx
	mov       dword ptr [ebp-44],eax
@100:
	mov       eax,offset @@_$ECTSE$@TForm1@DesenhaTrapezio$qqrsssss
	call      @__InitExceptBlockLDTC
	?debug L 486
	mov       edx,dword ptr [ebp-44]
	mov       eax,dword ptr [edx+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       dword ptr [ebp-52],eax
	?debug L 488
	mov       eax,dword ptr [ebp-44]
	call      @@TForm1@ApagaImagem$qqrv
	?debug L 489
	mov       word ptr [ebp-24],8
	mov       edx,offset s@+738
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-12]
	push      dword ptr [eax]
	mov       ecx,190
	mov       edx,230
	mov       eax,dword ptr [ebp-52]
	call      @@Graphics@TCanvas@TextOutA$qqriix17System@AnsiString
	dec       dword ptr [ebp-12]
	lea       eax,dword ptr [ebp-4]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 491
	mov       ecx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],ecx
	?debug L 491
@101:
	mov       esp,ebp
	pop       ebp
	ret       12
	?debug L 0
@@TForm1@DesenhaTrapezio$qqrsssss	endp
@TForm1@DesenhaTrapezio$qqrsssss	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	79
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch80
	dd	?patch81
	dd	?patch82
	df	@@TForm1@DesenhaTrapezio$qqrsssss
	dw	0
	dw	4361
	dw	0
	dw	220
	dw	0
	dw	0
	dw	0
	db	32
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	68
	db	101
	db	115
	db	101
	db	110
	db	104
	db	97
	db	84
	db	114
	db	97
	db	112
	db	101
	db	122
	db	105
	db	111
	db	36
	db	113
	db	113
	db	114
	db	115
	db	115
	db	115
	db	115
	db	115
	dw	18
	dw	512
	dw	65492
	dw	65535
	dw	4291
	dw	0
	dw	221
	dw	0
	dw	0
	dw	0
	dw	?patch83
	dw	529
	dw	?patch84
	dd	?live16416@0-@@TForm1@DesenhaTrapezio$qqrsssss
	dd	?live16416@0-?live16416@0
	dw	17
?patch84	equ	1
?patch83	equ	14
	dw	18
	dw	512
	dw	65490
	dw	65535
	dw	17
	dw	0
	dw	222
	dw	0
	dw	0
	dw	0
	dw	?patch85
	dw	529
	dw	?patch86
	dd	?live16416@0-@@TForm1@DesenhaTrapezio$qqrsssss
	dd	?live16416@0-?live16416@0
	dw	11
?patch86	equ	1
?patch85	equ	14
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	17
	dw	0
	dw	223
	dw	0
	dw	0
	dw	0
	dw	?patch87
	dw	529
	dw	?patch88
	dd	?live16416@0-@@TForm1@DesenhaTrapezio$qqrsssss
	dd	?live16416@0-?live16416@0
	dw	10
?patch88	equ	1
?patch87	equ	14
	dw	18
	dw	512
	dw	16
	dw	0
	dw	17
	dw	0
	dw	224
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	12
	dw	0
	dw	17
	dw	0
	dw	225
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	8
	dw	0
	dw	17
	dw	0
	dw	226
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	65484
	dw	65535
	dw	65531
	dw	65535
	dw	227
	dw	0
	dw	0
	dw	0
?patch80	equ	@101-@@TForm1@DesenhaTrapezio$qqrsssss+6
?patch81	equ	0
?patch82	equ	@101-@@TForm1@DesenhaTrapezio$qqrsssss
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCTE$@TForm1@DesenhaDivisa$qqrsssss	segment virtual
	align	2
@@_$DCTE$@TForm1@DesenhaDivisa$qqrsssss	label	dword
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-4
	dd	0
@_$DCTE$@TForm1@DesenhaDivisa$qqrsssss	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTUE$@TForm1@DesenhaDivisa$qqrsssss	segment virtual
	align	2
@@_$ECTUE$@TForm1@DesenhaDivisa$qqrsssss	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCTE$@TForm1@DesenhaDivisa$qqrsssss
@_$ECTUE$@TForm1@DesenhaDivisa$qqrsssss	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@DesenhaDivisa$qqrsssss	segment virtual
@@TForm1@DesenhaDivisa$qqrsssss	proc	near
?live16419@0:
	?debug L 495
	push      ebp
	mov       ebp,esp
	add       esp,-52
	mov       word ptr [ebp-48],cx
	mov       word ptr [ebp-46],dx
	mov       dword ptr [ebp-44],eax
@102:
	mov       eax,offset @@_$ECTUE$@TForm1@DesenhaDivisa$qqrsssss
	call      @__InitExceptBlockLDTC
	?debug L 497
	mov       edx,dword ptr [ebp-44]
	mov       eax,dword ptr [edx+720]
	call      @@Extctrls@TImage@GetCanvas$qqrv
	mov       dword ptr [ebp-52],eax
	?debug L 499
	mov       eax,dword ptr [ebp-44]
	call      @@TForm1@ApagaImagem$qqrv
	?debug L 500
	mov       word ptr [ebp-24],8
	mov       edx,offset s@+761
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@$bctr$qqrpxc
	inc       dword ptr [ebp-12]
	push      dword ptr [eax]
	mov       ecx,210
	mov       edx,230
	mov       eax,dword ptr [ebp-52]
	call      @@Graphics@TCanvas@TextOutA$qqriix17System@AnsiString
	dec       dword ptr [ebp-12]
	lea       eax,dword ptr [ebp-4]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	?debug L 502
	mov       ecx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],ecx
	?debug L 502
@103:
	mov       esp,ebp
	pop       ebp
	ret       12
	?debug L 0
@@TForm1@DesenhaDivisa$qqrsssss	endp
@TForm1@DesenhaDivisa$qqrsssss	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	77
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch89
	dd	?patch90
	dd	?patch91
	df	@@TForm1@DesenhaDivisa$qqrsssss
	dw	0
	dw	4363
	dw	0
	dw	228
	dw	0
	dw	0
	dw	0
	db	30
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	68
	db	101
	db	115
	db	101
	db	110
	db	104
	db	97
	db	68
	db	105
	db	118
	db	105
	db	115
	db	97
	db	36
	db	113
	db	113
	db	114
	db	115
	db	115
	db	115
	db	115
	db	115
	dw	18
	dw	512
	dw	65492
	dw	65535
	dw	4291
	dw	0
	dw	229
	dw	0
	dw	0
	dw	0
	dw	?patch92
	dw	529
	dw	?patch93
	dd	?live16419@0-@@TForm1@DesenhaDivisa$qqrsssss
	dd	?live16419@0-?live16419@0
	dw	17
?patch93	equ	1
?patch92	equ	14
	dw	18
	dw	512
	dw	65490
	dw	65535
	dw	17
	dw	0
	dw	230
	dw	0
	dw	0
	dw	0
	dw	?patch94
	dw	529
	dw	?patch95
	dd	?live16419@0-@@TForm1@DesenhaDivisa$qqrsssss
	dd	?live16419@0-?live16419@0
	dw	11
?patch95	equ	1
?patch94	equ	14
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	17
	dw	0
	dw	231
	dw	0
	dw	0
	dw	0
	dw	?patch96
	dw	529
	dw	?patch97
	dd	?live16419@0-@@TForm1@DesenhaDivisa$qqrsssss
	dd	?live16419@0-?live16419@0
	dw	10
?patch97	equ	1
?patch96	equ	14
	dw	18
	dw	512
	dw	16
	dw	0
	dw	17
	dw	0
	dw	232
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	12
	dw	0
	dw	17
	dw	0
	dw	233
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	8
	dw	0
	dw	17
	dw	0
	dw	234
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	65484
	dw	65535
	dw	65531
	dw	65535
	dw	235
	dw	0
	dw	0
	dw	0
?patch89	equ	@103-@@TForm1@DesenhaDivisa$qqrsssss+6
?patch90	equ	0
?patch91	equ	@103-@@TForm1@DesenhaDivisa$qqrsssss
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCVE$@Forms@TForm@$bctr$qqrp18Classes@TComponent	segment virtual
	align	2
@@_$DCVE$@Forms@TForm@$bctr$qqrp18Classes@TComponent	label	dword
	dd	@@$xt$p11Forms@TForm
	dd	1029
	dd	-4
	dd	0
@_$DCVE$@Forms@TForm@$bctr$qqrp18Classes@TComponent	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTWE$@Forms@TForm@$bctr$qqrp18Classes@TComponent	segment virtual
	align	2
@@_$ECTWE$@Forms@TForm@$bctr$qqrp18Classes@TComponent	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCVE$@Forms@TForm@$bctr$qqrp18Classes@TComponent
@_$ECTWE$@Forms@TForm@$bctr$qqrp18Classes@TComponent	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@Forms@TForm@$bctr$qqrp18Classes@TComponent	segment virtual
@@Forms@TForm@$bctr$qqrp18Classes@TComponent	proc	near
?live16386@0:
	?debug	T "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\forms.hpp"
	?debug L 932
	push      ebp
	mov       ebp,esp
	add       esp,-48
	mov       byte ptr [ebp-8],dl
	test      dl,dl
	jle       short @104
	call      __ClassCreate
@104:
	mov       dword ptr [ebp-48],ecx
	mov       byte ptr [ebp-41],dl
	mov       dword ptr [ebp-4],eax
@105:
	mov       eax,offset @@_$ECTWE$@Forms@TForm@$bctr$qqrp18Classes@TComponent
	call      @__InitExceptBlockLDTC
	mov       word ptr [ebp-24],8
	mov       ecx,dword ptr [ebp-48]
	xor       edx,edx
	mov       eax,dword ptr [ebp-4]
	call      @@Forms@TCustomForm@$bctr$qqrp18Classes@TComponent
	add       dword ptr [ebp-12],14
	?debug L 933
	mov       edx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],edx
	mov       eax,dword ptr [ebp-4]
@107:
@106:
	cmp       byte ptr [ebp-41],0
	je        short @108
	call      __AfterConstruction
	?debug L 933
@108:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@Forms@TForm@$bctr$qqrp18Classes@TComponent	endp
@Forms@TForm@$bctr$qqrp18Classes@TComponent	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	90
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch98
	dd	?patch99
	dd	?patch100
	df	@@Forms@TForm@$bctr$qqrp18Classes@TComponent
	dw	0
	dw	4365
	dw	0
	dw	236
	dw	0
	dw	0
	dw	0
	db	43
	db	64
	db	70
	db	111
	db	114
	db	109
	db	115
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	64
	db	36
	db	98
	db	99
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	112
	db	49
	db	56
	db	67
	db	108
	db	97
	db	115
	db	115
	db	101
	db	115
	db	64
	db	84
	db	67
	db	111
	db	109
	db	112
	db	111
	db	110
	db	101
	db	110
	db	116
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4366
	dw	0
	dw	237
	dw	0
	dw	0
	dw	0
	dw	?patch101
	dw	529
	dw	?patch102
	dd	?live16386@0-@@Forms@TForm@$bctr$qqrp18Classes@TComponent
	dd	?live16386@0-?live16386@0
	dw	17
?patch102	equ	1
?patch101	equ	14
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	65522
	dw	65535
	dw	238
	dw	0
	dw	0
	dw	0
	dw	?patch103
	dw	529
	dw	?patch104
	dd	?live16386@0-@@Forms@TForm@$bctr$qqrp18Classes@TComponent
	dd	?live16386@0-?live16386@0
	dw	18
?patch104	equ	1
?patch103	equ	14
?patch98	equ	@107-@@Forms@TForm@$bctr$qqrp18Classes@TComponent+15
?patch99	equ	0
?patch100	equ	@107-@@Forms@TForm@$bctr$qqrp18Classes@TComponent
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$ECTXE$@Windows@TRect@$bctr$qiiii	segment virtual
	align	2
@@_$ECTXE$@Windows@TRect@$bctr$qiiii	label	dword
	dd	0
	dd	-36
@_$ECTXE$@Windows@TRect@$bctr$qiiii	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@Windows@TRect@$bctr$qiiii	segment virtual
@@Windows@TRect@$bctr$qiiii	proc	near
?live16392@0:
	?debug	T "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\windows.hpp"
	?debug L 73
	push      ebp
	mov       ebp,esp
	add       esp,-36
@109:
	mov       eax,offset @@_$ECTXE$@Windows@TRect@$bctr$qiiii
	call      @__InitExceptBlockLDTC
	mov       edx,dword ptr [ebp+12]
	mov       ecx,dword ptr [ebp+8]
	mov       dword ptr [ecx],edx
	mov       eax,dword ptr [ebp+16]
	mov       edx,dword ptr [ebp+8]
	mov       dword ptr [edx+4],eax
	mov       ecx,dword ptr [ebp+20]
	mov       eax,dword ptr [ebp+8]
	mov       dword ptr [eax+8],ecx
	mov       edx,dword ptr [ebp+24]
	mov       ecx,dword ptr [ebp+8]
	mov       dword ptr [ecx+12],edx
	mov       eax,dword ptr [ebp-36]
	mov       dword ptr fs:[0],eax
	mov       eax,dword ptr [ebp+8]
	?debug L 73
@111:
@110:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@Windows@TRect@$bctr$qiiii	endp
@Windows@TRect@$bctr$qiiii	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	73
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch105
	dd	?patch106
	dd	?patch107
	df	@@Windows@TRect@$bctr$qiiii
	dw	0
	dw	4368
	dw	0
	dw	239
	dw	0
	dw	0
	dw	0
	db	26
	db	64
	db	87
	db	105
	db	110
	db	100
	db	111
	db	119
	db	115
	db	64
	db	84
	db	82
	db	101
	db	99
	db	116
	db	64
	db	36
	db	98
	db	99
	db	116
	db	114
	db	36
	db	113
	db	105
	db	105
	db	105
	db	105
	dw	18
	dw	512
	dw	8
	dw	0
	dw	4369
	dw	0
	dw	240
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	12
	dw	0
	dw	116
	dw	0
	dw	241
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	16
	dw	0
	dw	116
	dw	0
	dw	242
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	20
	dw	0
	dw	116
	dw	0
	dw	243
	dw	0
	dw	0
	dw	0
	dw	18
	dw	512
	dw	24
	dw	0
	dw	116
	dw	0
	dw	244
	dw	0
	dw	0
	dw	0
?patch105	equ	@111-@@Windows@TRect@$bctr$qiiii+4
?patch106	equ	0
?patch107	equ	@111-@@Windows@TRect@$bctr$qiiii
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCYE$@System@AnsiString@$bctr$qqrv	segment virtual
	align	2
@@_$DCYE$@System@AnsiString@$bctr$qqrv	label	dword
	dd	@@$xt$p17System@AnsiString
	dd	5
	dd	-4
	dd	0
@_$DCYE$@System@AnsiString@$bctr$qqrv	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTZE$@System@AnsiString@$bctr$qqrv	segment virtual
	align	2
@@_$ECTZE$@System@AnsiString@$bctr$qqrv	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCYE$@System@AnsiString@$bctr$qqrv
@_$ECTZE$@System@AnsiString@$bctr$qqrv	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@System@AnsiString@$bctr$qqrv	segment virtual
@@System@AnsiString@$bctr$qqrv	proc	near
?live16397@0:
	?debug	T "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\dstring.h"
	?debug L 68
	push      ebp
	mov       ebp,esp
	add       esp,-40
	mov       dword ptr [ebp-4],eax
@112:
	mov       eax,offset @@_$ECTZE$@System@AnsiString@$bctr$qqrv
	call      @__InitExceptBlockLDTC
	mov       word ptr [ebp-24],8
	mov       edx,dword ptr [ebp-4]
	xor       ecx,ecx
	mov       dword ptr [edx],ecx
	mov       eax,dword ptr [ebp-40]
	mov       dword ptr fs:[0],eax
	mov       eax,dword ptr [ebp-4]
	?debug L 68
@114:
@113:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@System@AnsiString@$bctr$qqrv	endp
@System@AnsiString@$bctr$qqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	76
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch108
	dd	?patch109
	dd	?patch110
	df	@@System@AnsiString@$bctr$qqrv
	dw	0
	dw	4371
	dw	0
	dw	245
	dw	0
	dw	0
	dw	0
	db	29
	db	64
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	65
	db	110
	db	115
	db	105
	db	83
	db	116
	db	114
	db	105
	db	110
	db	103
	db	64
	db	36
	db	98
	db	99
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4372
	dw	0
	dw	246
	dw	0
	dw	0
	dw	0
	dw	?patch111
	dw	529
	dw	?patch112
	dd	?live16397@0-@@System@AnsiString@$bctr$qqrv
	dd	?live16397@0-?live16397@0
	dw	17
?patch112	equ	1
?patch111	equ	14
?patch108	equ	@114-@@System@AnsiString@$bctr$qqrv+4
?patch109	equ	0
?patch110	equ	@114-@@System@AnsiString@$bctr$qqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@System@AnsiString@Length$xqqrv	segment virtual
@@System@AnsiString@Length$xqqrv	proc	near
?live16398@0:
	?debug L 254
	push      ebp
	mov       ebp,esp
	push      ecx
	mov       dword ptr [ebp-4],eax
	?debug L 256
@115:
	mov       eax,dword ptr [ebp-4]
	cmp       dword ptr [eax],0
	je        short @116
	push      dword ptr [ebp-4]
	call      @@System@AnsiString@GetRec$xqv
	pop       ecx
	mov       eax,dword ptr [eax+8]
	jmp       short @118
@116:
	xor       eax,eax
	?debug L 257
@119:
@118:
	pop       ecx
	pop       ebp
	ret 
	?debug L 0
@@System@AnsiString@Length$xqqrv	endp
@System@AnsiString@Length$xqqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	78
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch113
	dd	?patch114
	dd	?patch115
	df	@@System@AnsiString@Length$xqqrv
	dw	0
	dw	4374
	dw	0
	dw	247
	dw	0
	dw	0
	dw	0
	db	31
	db	64
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	65
	db	110
	db	115
	db	105
	db	83
	db	116
	db	114
	db	105
	db	110
	db	103
	db	64
	db	76
	db	101
	db	110
	db	103
	db	116
	db	104
	db	36
	db	120
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4375
	dw	0
	dw	248
	dw	0
	dw	0
	dw	0
	dw	?patch116
	dw	529
	dw	?patch117
	dd	?live16398@0-@@System@AnsiString@Length$xqqrv
	dd	?live16398@0-?live16398@0
	dw	17
?patch117	equ	1
?patch116	equ	14
?patch113	equ	@119-@@System@AnsiString@Length$xqqrv+3
?patch114	equ	0
?patch115	equ	@119-@@System@AnsiString@Length$xqqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@System@AnsiString@GetRec$xqv	segment virtual
@@System@AnsiString@GetRec$xqv	proc	near
?live16429@0:
	?debug L 244
	push      ebp
	mov       ebp,esp
	?debug L 246
@120:
	mov       eax,dword ptr [ebp+8]
	mov       eax,dword ptr [eax]
	add       eax,-12
	?debug L 247
@122:
@121:
	pop       ebp
	ret 
	?debug L 0
@@System@AnsiString@GetRec$xqv	endp
@System@AnsiString@GetRec$xqv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	76
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch118
	dd	?patch119
	dd	?patch120
	df	@@System@AnsiString@GetRec$xqv
	dw	0
	dw	4378
	dw	0
	dw	249
	dw	0
	dw	0
	dw	0
	db	29
	db	64
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	65
	db	110
	db	115
	db	105
	db	83
	db	116
	db	114
	db	105
	db	110
	db	103
	db	64
	db	71
	db	101
	db	116
	db	82
	db	101
	db	99
	db	36
	db	120
	db	113
	db	118
	dw	18
	dw	512
	dw	8
	dw	0
	dw	4375
	dw	0
	dw	250
	dw	0
	dw	0
	dw	0
?patch118	equ	@122-@@System@AnsiString@GetRec$xqv+2
?patch119	equ	0
?patch120	equ	@122-@@System@AnsiString@GetRec$xqv
	dw	2
	dw	6
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@$xt$p17System@AnsiString	segment virtual
	align	2
@@$xt$p17System@AnsiString	label	dword
	dd	4
	dw	16
	dw	12
	dd	@@$xt$17System@AnsiString
	db	65
	db	110
	db	115
	db	105
	db	83
	db	116
	db	114
	db	105
	db	110
	db	103
	db	32
	db	42
	db	0
@$xt$p17System@AnsiString	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$p11Forms@TForm	segment virtual
	align	2
@@$xt$p11Forms@TForm	label	dword
	dd	4
	dw	144
	dw	12
	dd	@@$xt$11Forms@TForm
	db	84
	db	70
	db	111
	db	114
	db	109
	db	32
	db	42
	db	0
@$xt$p11Forms@TForm	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$p13Windows@TRect	segment virtual
	align	2
@@$xt$p13Windows@TRect	label	dword
	dd	4
	dw	144
	dw	12
	dd	@@$xt$13Windows@TRect
	db	84
	db	82
	db	101
	db	99
	db	116
	db	32
	db	42
	db	0
@$xt$p13Windows@TRect	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$17System@AnsiString	segment virtual
	align	2
@@$xt$17System@AnsiString	label	byte
	dd	4
	dw	3
	dw	48
	dd	-1
	dd	3
	dw	68
	dw	72
	dd	0
	dw	0
	dw	0
	dd	0
	dd	1
	dd	1
	dd	@@System@AnsiString@$bdtr$qqrv
	dw	3
	dw	76
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	58
	db	58
	db	65
	db	110
	db	115
	db	105
	db	83
	db	116
	db	114
	db	105
	db	110
	db	103
	db	0
	db	0
	dd	0
	dd	0
	dd	0
@$xt$17System@AnsiString	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$p6TForm1	segment virtual
	align	2
@@$xt$p6TForm1	label	dword
	dd	4
	dw	144
	dw	12
	dd	@@$xt$6TForm1
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	32
	db	42
	db	0
@$xt$p6TForm1	ends
_TEXT	ends
_DATA	segment dword public use32 'DATA'
@TForm1@	segment virtual
	align	2
@@TForm1@	label	byte
	dd	@@TForm1@+76
	dd	0
	dd	0
	dd	0
	dd	@@$xp$6TForm1+4
	dd	@@TForm1@+300
	dd	@@TForm1@+628
	dd	0
	dd	@@TForm1@+687
	dd	812
	dd	@Forms@TForm@
	dd	@@Classes@TComponent@SafeCallException$qqrp14System@TObjectpv
	dd	@@Forms@TCustomForm@AfterConstruction$qqrv
	dd	@@Forms@TCustomForm@BeforeDestruction$qqrv
	dd	@@System@TObject@Dispatch$qqrpv
	dd	@@Forms@TCustomForm@DefaultHandler$qqrpv
	dd	@@System@TObject@NewInstance$qqrp17System@TMetaClass
	dd	@@System@TObject@FreeInstance$qqrv
	dd	@@TForm1@$bdtr$qqrv
	dd	@@Controls@TWinControl@AssignTo$qqrp19Classes@TPersistent
	dd	@@Forms@TCustomForm@DefineProperties$qqrp14Classes@TFiler
	dd	@@Classes@TPersistent@Assign$qqrp19Classes@TPersistent
	dd	@@Forms@TCustomForm@Loaded$qqrv
	dd	@@Forms@TCustomForm@Notification$qqrp18Classes@TComponent18Classes@TOperation
	dd	@@Forms@TCustomForm@ReadState$qqrp15Classes@TReader
	dd	@@Controls@TControl@SetName$qqrx17System@AnsiString
	dd	@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	dd	@@Forms@TCustomForm@ValidateRename$qqrp18Classes@TComponentx17System@AnsiStringt2
	dd	@@Classes@TComponent@WriteState$qqrp15Classes@TWriter
	dd	@@Forms@TCustomForm@QueryInterface$qqsrx5_GUIDpv
	dd	@@TForm1@$bctr$qqrp18Classes@TComponent
	dd	@@Controls@TWinControl@CanResize$qqrrit1
	dd	@@Controls@TWinControl@CanAutoSize$qqrrit1
	dd	@@Controls@TWinControl@ConstrainedResize$qqrrit1t1t1
	dd	@@Controls@TWinControl@GetClientOrigin$qqrv
	dd	@@Forms@TCustomForm@GetClientRect$qqrv
	dd	@@Controls@TWinControl@GetDeviceContext$qqrrpv
	dd	@@Controls@TControl@GetDragImages$qqrv
	dd	@@Controls@TControl@GetEnabled$qqrv
	dd	@@Forms@TCustomForm@GetFloating$qqrv
	dd	@@Controls@TControl@GetFloatingDockSiteClass$qqrv
	dd	@@Controls@TControl@SetDragMode$qqr18Controls@TDragMode
	dd	@@Controls@TControl@SetEnabled$qqro
	dd	@@Forms@TCustomForm@SetParent$qqrp20Controls@TWinControl
	dd	@@Forms@TCustomForm@SetParentBiDiMode$qqro
	dd	@@Controls@TControl@SetBiDiMode$qqr17Classes@TBiDiMode
	dd	@@Forms@TCustomForm@WndProc$qqrr17Messages@TMessage
	dd	@@Controls@TControl@InitiateAction$qqrv
	dd	@@Controls@TWinControl@Invalidate$qqrv
	dd	@@Controls@TWinControl@Repaint$qqrv
	dd	@@Controls@TWinControl@SetBounds$qqriiii
	dd	@@Controls@TWinControl@Update$qqrv
	dd	@@Forms@TScrollingWinControl@AdjustClientRect$qqrr13Windows@TRect
	dd	@@Forms@TCustomForm@AlignControls$qqrp17Controls@TControlr13Windows@TRect
	dd	@@Controls@TWinControl@CreateHandle$qqrv
	dd	@@Forms@TCustomForm@CreateParams$qqrr22Controls@TCreateParams
	dd	@@Forms@TCustomForm@CreateWindowHandle$qqrrx22Controls@TCreateParams
	dd	@@Forms@TCustomForm@CreateWnd$qqrv
	dd	@@Forms@TCustomForm@DestroyWindowHandle$qqrv
	dd	@@Controls@TWinControl@DestroyWnd$qqrv
	dd	@@Controls@TWinControl@GetControlExtents$qqrv
	dd	@@Forms@TCustomForm@PaintWindow$qqrpv
	dd	@@Controls@TWinControl@ShowControl$qqrp17Controls@TControl
	dd	@@Forms@TCustomForm@SetFocus$qqrv
	dd	@@Forms@TScrollingWinControl@AutoScrollEnabled$qqrv
	dd	@@Forms@TScrollingWinControl@AutoScrollInView$qqrp17Controls@TControl
	dd	@@Forms@TCustomForm@Resizing$qqr18Forms@TWindowState
	dd	@@Forms@TCustomForm@DoCreate$qqrv
	dd	@@Forms@TCustomForm@DoDestroy$qqrv
	dd	@@Forms@TCustomForm@UpdateActions$qqrv
	dd	@@Forms@TForm@$bctr$qqrp18Classes@TComponenti
	dd	@@Forms@TCustomForm@CloseQuery$qqrv
	dd	@@Forms@TCustomForm@SetFocusedControl$qqrp20Controls@TWinControl
	dd	@@Forms@TCustomForm@ShowModal$qqrv
	dd	@@Forms@TCustomForm@WantChildKey$qqrp17Controls@TControlr17Messages@TMessage
	dw	23
	dd	@@TForm1@+694
	dd	720
	dw	0
	db	6
	db        73,109,97,103,101,49
	dd	724
	dw	1
	db	6
	db        80,97,110,101,108,49
	dd	728
	dw	2
	db	7
	db        68,101,115,101,110,104,97
	dd	732
	dw	3
	db	6
	db        70,105,103,117,114,97
	dd	736
	dw	4
	db	9
	db        71,114,111,117,112,66,111,120,49
	dd	740
	dw	5
	db	6
	db        76,97,98,101,108,49
	dd	744
	dw	5
	db	6
	db        76,97,98,101,108,50
	dd	748
	dw	4
	db	9
	db        71,114,111,117,112,66,111,120,50
	dd	752
	dw	5
	db	6
	db        76,97,98,101,108,51
	dd	756
	dw	5
	db	6
	db        76,97,98,101,108,52
	dd	760
	dw	6
	db	4
	db        69,100,88,50
	dd	764
	dw	6
	db	4
	db        69,100,89,50
	dd	768
	dw	6
	db	4
	db        69,100,88,49
	dd	772
	dw	6
	db	4
	db        69,100,89,49
	dd	776
	dw	7
	db	11
	db        82,97,100,105,111,71,114,111,117,112,49
	dd	780
	dw	8
	db	12
	db        82,97,100,105,111,66,117,116,116,111,110,49
	dd	784
	dw	8
	db	12
	db        82,97,100,105,111,66,117,116,116,111,110,50
	dd	788
	dw	4
	db	9
	db        71,114,111,117,112,66,111,120,51
	dd	792
	dw	5
	db	6
	db        76,97,98,101,108,53
	dd	796
	dw	6
	db	4
	db        69,100,88,51
	dd	800
	dw	4
	db	9
	db        77,101,110,115,97,103,101,110,115
	dd	804
	dw	5
	db	8
	db        77,101,110,115,97,103,101,109
	dd	808
	dw	2
	db	7
	db        66,105,116,66,116,110,49
	dw	3
	dw	19
	dd	@@TForm1@DesenhaClick$qqrp14System@TObject
	db	12
	db        68,101,115,101,110,104,97,67,108,105,99,107
	dw	19
	dd	@@TForm1@FiguraChange$qqrp14System@TObject
	db	12
	db        70,105,103,117,114,97,67,104,97,110,103,101
	dw	19
	dd	@@TForm1@BitBtn1Click$qqrp14System@TObject
	db	12
	db        66,105,116,66,116,110,49,67,108,105,99,107
	db	6
	db        84,70,111,114,109,49
	dw	9
	dd	@Extctrls@TImage@
	dd	@Extctrls@TPanel@
	dd	@Buttons@TBitBtn@
	dd	@Stdctrls@TComboBox@
	dd	@Stdctrls@TGroupBox@
	dd	@Stdctrls@TLabel@
	dd	@Stdctrls@TEdit@
	dd	@Extctrls@TRadioGroup@
	dd	@Stdctrls@TRadioButton@
@TForm1@	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@$xp$6TForm1	segment virtual
	align	2
@@$xp$6TForm1	label	byte
	dd	@@$xp$6TForm1+4
	db	7
	db	6
	db        84,70,111,114,109,49
	dd	@@TForm1@+76
	dd	@$xp$11Forms@TForm
	dw	86
	db	9
	db        118,101,114,115,97,111,50,95,48
	dw	0
@$xp$6TForm1	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$6TForm1	segment virtual
	align	2
@@$xt$6TForm1	label	byte
	dd	812
	dw	3
	dw	48
	dd	0
	dd	183
	dw	56
	dw	72
	dd	0
	dw	0
	dw	0
	dd	0
	dd	16
	dd	16
	dd	@@TForm1@$bdtr$qqrv
	dw	3
	dw	76
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	0
	db	0
	dd	@@$xt$11Forms@TForm
	dd	0
	dd	3
	dd	0
	dd	0
	dd	0
@$xt$6TForm1	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$13Windows@TRect	segment virtual
	align	2
@@$xt$13Windows@TRect	label	byte
	dd	16
	dw	3
	dw	32
	dd	-1
	dd	5
	dw	48
	dw	64
	dd	0
	dw	0
	dw	0
	dd	0
	db	87
	db	105
	db	110
	db	100
	db	111
	db	119
	db	115
	db	58
	db	58
	db	84
	db	82
	db	101
	db	99
	db	116
	db	0
	db	0
	dd	@@$xt$7tagRECT
	dd	0
	dd	3
	dd	0
	dd	0
@$xt$13Windows@TRect	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$11Forms@TForm	segment virtual
	align	2
@@$xt$11Forms@TForm	label	byte
	dd	720
	dw	3
	dw	48
	dd	0
	dd	183
	dw	64
	dw	80
	dd	0
	dw	0
	dw	0
	dd	0
	dd	15
	dd	15
	dd	@@Forms@TForm@$bdtr$qqrv
	dw	3
	dw	84
	db	70
	db	111
	db	114
	db	109
	db	115
	db	58
	db	58
	db	84
	db	70
	db	111
	db	114
	db	109
	db	0
	db	0
	db	0
	db	0
	dd	@@$xt$17Forms@TCustomForm
	dd	0
	dd	3
	dd	0
	dd	0
	dd	0
@$xt$11Forms@TForm	ends
_TEXT	ends
_DATA	segment dword public use32 'DATA'
@_$ECTAF$@TForm1@$bdtr$qqrv	segment virtual
	align	2
@@_$ECTAF$@TForm1@$bdtr$qqrv	label	dword
	dd	0
	dd	-36
@_$ECTAF$@TForm1@$bdtr$qqrv	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@TForm1@$bdtr$qqrv	segment virtual
@@TForm1@$bdtr$qqrv	proc	near
?live16435@0:
	?debug L 0
	push      ebp
	mov       ebp,esp
	add       esp,-44
	call      __BeforeDestruction
	mov       byte ptr [ebp-41],dl
	mov       dword ptr [ebp-40],eax
@123:
	mov       eax,offset @@_$ECTAF$@TForm1@$bdtr$qqrv
	call      @__InitExceptBlockLDTC
	cmp       byte ptr [ebp-41],0
	jl        short @124
	sub       dword ptr [ebp-8],15
	xor       edx,edx
	mov       eax,dword ptr [ebp-40]
	call      @@Forms@TForm@$bdtr$qqrv
@124:
@125:
	mov       edx,dword ptr [ebp-36]
	mov       dword ptr fs:[0],edx
@127:
@126:
	cmp       byte ptr [ebp-41],0
	jle       short @128
	mov       eax,dword ptr [ebp-40]
	call      __ClassDestroy
	?debug L 247
@128:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@TForm1@$bdtr$qqrv	endp
@TForm1@$bdtr$qqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	65
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch121
	dd	?patch122
	dd	?patch123
	df	@@TForm1@$bdtr$qqrv
	dw	0
	dw	4380
	dw	0
	dw	251
	dw	0
	dw	0
	dw	0
	db	18
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	49
	db	64
	db	36
	db	98
	db	100
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65496
	dw	65535
	dw	4291
	dw	0
	dw	252
	dw	0
	dw	0
	dw	0
	dw	?patch124
	dw	529
	dw	?patch125
	dd	?live16435@0-@@TForm1@$bdtr$qqrv
	dd	?live16435@0-?live16435@0
	dw	17
?patch125	equ	1
?patch124	equ	14
?patch121	equ	@127-@@TForm1@$bdtr$qqrv+18
?patch122	equ	0
?patch123	equ	@127-@@TForm1@$bdtr$qqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCBF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	segment virtual
	align	2
@@_$DCBF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	label	dword
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-4
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	8
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-8
	dd	@@$xt$17System@AnsiString
	dd	4
	dd	-12
	dd	0
@_$DCBF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTCF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	segment virtual
	align	2
@@_$ECTCF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	label	dword
	dd	0
	dd	-48
	dw	0
	dw	5
	dd	2
	dd	@@_$DCBF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	dw	8
	dw	5
	dd	4
	dd	@@_$DCBF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2+28
@_$ECTCF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	segment virtual
@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	proc	near
?live16436@0:
	?debug	T "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\classes.hpp"
	?debug L 2068
	push      ebp
	mov       ebp,esp
	add       esp,-56
	mov       dword ptr [ebp-4],ecx
	mov       byte ptr [ebp-53],dl
	mov       dword ptr [ebp-52],eax
@129:
	mov       eax,offset @@_$ECTCF$@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	call      @__InitExceptBlockLDTC
	mov       dword ptr [ebp-20],2
	lea       edx,dword ptr [ebp-4]
	lea       eax,dword ptr [ebp-4]
	call      @@System@AnsiString@$bctr$qqrrx17System@AnsiString
	inc       dword ptr [ebp-20]
	?debug L 2069
	mov       word ptr [ebp-32],8
	lea       edx,dword ptr [ebp+8]
	lea       eax,dword ptr [ebp+8]
	call      @@System@AnsiString@$bctr$qqrrx17System@AnsiString
	inc       dword ptr [ebp-20]
	lea       edx,dword ptr [ebp+8]
	lea       eax,dword ptr [ebp-12]
	call      @@System@AnsiString@$bctr$qqrrx17System@AnsiString
	inc       dword ptr [ebp-20]
	push      dword ptr [eax]
	mov       word ptr [ebp-32],20
	lea       edx,dword ptr [ebp-4]
	lea       eax,dword ptr [ebp-8]
	call      @@System@AnsiString@$bctr$qqrrx17System@AnsiString
	inc       dword ptr [ebp-20]
	mov       ecx,dword ptr [eax]
	mov       dl,byte ptr [ebp-53]
	mov       eax,dword ptr [@Classes@TComponent@]
	call      @@Classes@TComponent@UpdateRegistry$qqrp17System@TMetaClassox17System@AnsiStringt3
	dec       dword ptr [ebp-20]
	lea       eax,dword ptr [ebp-12]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-20]
	lea       eax,dword ptr [ebp-8]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-20]
	lea       eax,dword ptr [ebp+8]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	dec       dword ptr [ebp-20]
	lea       eax,dword ptr [ebp-4]
	mov       edx,2
	call      @@System@AnsiString@$bdtr$qqrv
	mov       ecx,dword ptr [ebp-48]
	mov       dword ptr fs:[0],ecx
	?debug L 2069
@130:
	mov       esp,ebp
	pop       ebp
	ret       4
	?debug L 0
@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	endp
@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	108
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch126
	dd	?patch127
	dd	?patch128
	df	@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	dw	0
	dw	4382
	dw	0
	dw	253
	dw	0
	dw	0
	dw	0
	db	61
	db	64
	db	67
	db	108
	db	97
	db	115
	db	115
	db	101
	db	115
	db	64
	db	84
	db	67
	db	111
	db	109
	db	112
	db	111
	db	110
	db	101
	db	110
	db	116
	db	64
	db	85
	db	112
	db	100
	db	97
	db	116
	db	101
	db	82
	db	101
	db	103
	db	105
	db	115
	db	116
	db	114
	db	121
	db	36
	db	113
	db	113
	db	114
	db	111
	db	120
	db	49
	db	55
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	65
	db	110
	db	115
	db	105
	db	83
	db	116
	db	114
	db	105
	db	110
	db	103
	db	116
	db	50
	dw	18
	dw	512
	dw	65484
	dw	65535
	dw	4383
	dw	0
	dw	254
	dw	0
	dw	0
	dw	0
	dw	?patch129
	dw	529
	dw	?patch130
	dd	?live16436@0-@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	dd	?live16436@0-?live16436@0
	dw	17
?patch130	equ	1
?patch129	equ	14
	dw	18
	dw	512
	dw	65483
	dw	65535
	dw	48
	dw	0
	dw	255
	dw	0
	dw	0
	dw	0
	dw	?patch131
	dw	529
	dw	?patch132
	dd	?live16436@0-@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	dd	?live16436@0-?live16436@0
	dw	3
?patch132	equ	1
?patch131	equ	14
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4376
	dw	0
	dw	256
	dw	0
	dw	0
	dw	0
	dw	?patch133
	dw	529
	dw	?patch134
	dd	?live16436@0-@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	dd	?live16436@0-?live16436@0
	dw	0
?patch134	equ	1
?patch133	equ	14
	dw	18
	dw	512
	dw	8
	dw	0
	dw	4376
	dw	0
	dw	257
	dw	0
	dw	0
	dw	0
?patch126	equ	@130-@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2+6
?patch127	equ	0
?patch128	equ	@130-@@Classes@TComponent@UpdateRegistry$qqrox17System@AnsiStringt2
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCDF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti	segment virtual
	align	2
@@_$DCDF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti	label	dword
	dd	@@$xt$p11Forms@TForm
	dd	1029
	dd	-4
	dd	0
@_$DCDF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTEF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti	segment virtual
	align	2
@@_$ECTEF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCDF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti
@_$ECTEF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@Forms@TForm@$bctr$qqrp18Classes@TComponenti	segment virtual
@@Forms@TForm@$bctr$qqrp18Classes@TComponenti	proc	near
?live16437@0:
	?debug	T "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\forms.hpp"
	?debug L 936
	push      ebp
	mov       ebp,esp
	add       esp,-48
	mov       byte ptr [ebp-8],dl
	test      dl,dl
	jle       short @131
	call      __ClassCreate
@131:
	mov       dword ptr [ebp-48],ecx
	mov       byte ptr [ebp-41],dl
	mov       dword ptr [ebp-4],eax
@132:
	mov       eax,offset @@_$ECTEF$@Forms@TForm@$bctr$qqrp18Classes@TComponenti
	call      @__InitExceptBlockLDTC
	?debug L 937
	mov       word ptr [ebp-24],8
	push      dword ptr [ebp+8]
	mov       ecx,dword ptr [ebp-48]
	xor       edx,edx
	mov       eax,dword ptr [ebp-4]
	call      @@Forms@TCustomForm@$bctr$qqrp18Classes@TComponenti
	add       dword ptr [ebp-12],14
	mov       edx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],edx
	mov       eax,dword ptr [ebp-4]
@134:
@133:
	cmp       byte ptr [ebp-41],0
	je        short @135
	call      __AfterConstruction
	?debug L 937
@135:
	mov       esp,ebp
	pop       ebp
	ret       4
	?debug L 0
@@Forms@TForm@$bctr$qqrp18Classes@TComponenti	endp
@Forms@TForm@$bctr$qqrp18Classes@TComponenti	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	91
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch135
	dd	?patch136
	dd	?patch137
	df	@@Forms@TForm@$bctr$qqrp18Classes@TComponenti
	dw	0
	dw	4385
	dw	0
	dw	258
	dw	0
	dw	0
	dw	0
	db	44
	db	64
	db	70
	db	111
	db	114
	db	109
	db	115
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	64
	db	36
	db	98
	db	99
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	112
	db	49
	db	56
	db	67
	db	108
	db	97
	db	115
	db	115
	db	101
	db	115
	db	64
	db	84
	db	67
	db	111
	db	109
	db	112
	db	111
	db	110
	db	101
	db	110
	db	116
	db	105
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4366
	dw	0
	dw	259
	dw	0
	dw	0
	dw	0
	dw	?patch138
	dw	529
	dw	?patch139
	dd	?live16437@0-@@Forms@TForm@$bctr$qqrp18Classes@TComponenti
	dd	?live16437@0-?live16437@0
	dw	17
?patch139	equ	1
?patch138	equ	14
	dw	18
	dw	512
	dw	65488
	dw	65535
	dw	65522
	dw	65535
	dw	260
	dw	0
	dw	0
	dw	0
	dw	?patch140
	dw	529
	dw	?patch141
	dd	?live16437@0-@@Forms@TForm@$bctr$qqrp18Classes@TComponenti
	dd	?live16437@0-?live16437@0
	dw	18
?patch141	equ	1
?patch140	equ	14
	dw	18
	dw	512
	dw	8
	dw	0
	dw	116
	dw	0
	dw	261
	dw	0
	dw	0
	dw	0
?patch135	equ	@134-@@Forms@TForm@$bctr$qqrp18Classes@TComponenti+17
?patch136	equ	0
?patch137	equ	@134-@@Forms@TForm@$bctr$qqrp18Classes@TComponenti
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_DATA	segment dword public use32 'DATA'
@_$DCFF$@Forms@TForm@$bdtr$qqrv	segment virtual
	align	2
@@_$DCFF$@Forms@TForm@$bdtr$qqrv	label	dword
	dd	@@$xt$p11Forms@TForm
	dd	1029
	dd	-4
	dd	0
@_$DCFF$@Forms@TForm@$bdtr$qqrv	ends
_DATA	ends
_DATA	segment dword public use32 'DATA'
@_$ECTGF$@Forms@TForm@$bdtr$qqrv	segment virtual
	align	2
@@_$ECTGF$@Forms@TForm@$bdtr$qqrv	label	dword
	dd	0
	dd	-40
	dw	0
	dw	5
	dd	0
	dd	@@_$DCFF$@Forms@TForm@$bdtr$qqrv
@_$ECTGF$@Forms@TForm@$bdtr$qqrv	ends
_DATA	ends
_TEXT	segment dword public use32 'CODE'
@Forms@TForm@$bdtr$qqrv	segment virtual
@@Forms@TForm@$bdtr$qqrv	proc	near
?live16439@0:
	?debug L 940
	push      ebp
	mov       ebp,esp
	add       esp,-44
	call      __BeforeDestruction
	mov       byte ptr [ebp-41],dl
	mov       dword ptr [ebp-4],eax
@136:
	mov       eax,offset @@_$ECTGF$@Forms@TForm@$bdtr$qqrv
	call      @__InitExceptBlockLDTC
	mov       dword ptr [ebp-12],14
	cmp       byte ptr [ebp-41],0
	jl        short @137
	mov       word ptr [ebp-24],8
	sub       dword ptr [ebp-12],14
	xor       edx,edx
	mov       eax,dword ptr [ebp-4]
	call      @@Forms@TCustomForm@$bdtr$qqrv
@137:
	mov       edx,dword ptr [ebp-40]
	mov       dword ptr fs:[0],edx
@138:
	cmp       byte ptr [ebp-41],0
	jle       short @139
	mov       eax,dword ptr [ebp-4]
	call      __ClassDestroy
	?debug L 940
@139:
	mov       esp,ebp
	pop       ebp
	ret 
	?debug L 0
@@Forms@TForm@$bdtr$qqrv	endp
@Forms@TForm@$bdtr$qqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	70
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch142
	dd	?patch143
	dd	?patch144
	df	@@Forms@TForm@$bdtr$qqrv
	dw	0
	dw	4387
	dw	0
	dw	262
	dw	0
	dw	0
	dw	0
	db	23
	db	64
	db	70
	db	111
	db	114
	db	109
	db	115
	db	64
	db	84
	db	70
	db	111
	db	114
	db	109
	db	64
	db	36
	db	98
	db	100
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4366
	dw	0
	dw	263
	dw	0
	dw	0
	dw	0
	dw	?patch145
	dw	529
	dw	?patch146
	dd	?live16439@0-@@Forms@TForm@$bdtr$qqrv
	dd	?live16439@0-?live16439@0
	dw	17
?patch146	equ	1
?patch145	equ	14
?patch142	equ	@138-@@Forms@TForm@$bdtr$qqrv+18
?patch143	equ	0
?patch144	equ	@138-@@Forms@TForm@$bdtr$qqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@$xt$17Forms@TCustomForm	segment virtual
	align	2
@@$xt$17Forms@TCustomForm	label	byte
	dd	720
	dw	3
	dw	48
	dd	0
	dd	183
	dw	68
	dw	84
	dd	0
	dw	0
	dw	0
	dd	0
	dd	14
	dd	14
	dd	@@Forms@TCustomForm@$bdtr$qqrv
	dw	3
	dw	88
	db	70
	db	111
	db	114
	db	109
	db	115
	db	58
	db	58
	db	84
	db	67
	db	117
	db	115
	db	116
	db	111
	db	109
	db	70
	db	111
	db	114
	db	109
	db	0
	db	0
	dd	@@$xt$26Forms@TScrollingWinControl
	dd	0
	dd	3
	dd	0
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	548
	dd	@@$xt$43System@%DelphiInterface$t15Forms@IDesigner%
	dd	568
	dd	@@$xt$42System@%DelphiInterface$t14Forms@IOleForm%
	dd	588
	dd	0
@$xt$17Forms@TCustomForm	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$7tagRECT	segment virtual
	align	2
@@$xt$7tagRECT	label	byte
	dd	16
	dw	1
	dw	16
	dd	-1
	dd	0
	db	116
	db	97
	db	103
	db	82
	db	69
	db	67
	db	84
	db	0
@$xt$7tagRECT	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$42System@%DelphiInterface$t14Forms@IOleForm%	segment virtual
	align	2
@@$xt$42System@%DelphiInterface$t14Forms@IOleForm%	label	byte
	dd	4
	dw	3
	dw	48
	dd	-1
	dd	3
	dw	92
	dw	96
	dd	0
	dw	0
	dw	0
	dd	0
	dd	1
	dd	1
	dd	@@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv
	dw	3
	dw	100
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	58
	db	58
	db	68
	db	101
	db	108
	db	112
	db	104
	db	105
	db	73
	db	110
	db	116
	db	101
	db	114
	db	102
	db	97
	db	99
	db	101
	db	60
	db	70
	db	111
	db	114
	db	109
	db	115
	db	58
	db	58
	db	73
	db	79
	db	108
	db	101
	db	70
	db	111
	db	114
	db	109
	db	62
	db	0
	db	0
	db	0
	db	0
	dd	0
	dd	0
	dd	0
@$xt$42System@%DelphiInterface$t14Forms@IOleForm%	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$43System@%DelphiInterface$t15Forms@IDesigner%	segment virtual
	align	2
@@$xt$43System@%DelphiInterface$t15Forms@IDesigner%	label	byte
	dd	4
	dw	3
	dw	48
	dd	-1
	dd	3
	dw	92
	dw	96
	dd	0
	dw	0
	dw	0
	dd	0
	dd	1
	dd	1
	dd	@@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv
	dw	3
	dw	100
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	58
	db	58
	db	68
	db	101
	db	108
	db	112
	db	104
	db	105
	db	73
	db	110
	db	116
	db	101
	db	114
	db	102
	db	97
	db	99
	db	101
	db	60
	db	70
	db	111
	db	114
	db	109
	db	115
	db	58
	db	58
	db	73
	db	68
	db	101
	db	115
	db	105
	db	103
	db	110
	db	101
	db	114
	db	62
	db	0
	db	0
	db	0
	dd	0
	dd	0
	dd	0
@$xt$43System@%DelphiInterface$t15Forms@IDesigner%	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$26Forms@TScrollingWinControl	segment virtual
	align	2
@@$xt$26Forms@TScrollingWinControl	label	byte
	dd	520
	dw	3
	dw	48
	dd	0
	dd	183
	dw	76
	dw	92
	dd	0
	dw	0
	dw	0
	dd	0
	dd	10
	dd	10
	dd	@@Forms@TScrollingWinControl@$bdtr$qqrv
	dw	3
	dw	96
	db	70
	db	111
	db	114
	db	109
	db	115
	db	58
	db	58
	db	84
	db	83
	db	99
	db	114
	db	111
	db	108
	db	108
	db	105
	db	110
	db	103
	db	87
	db	105
	db	110
	db	67
	db	111
	db	110
	db	116
	db	114
	db	111
	db	108
	db	0
	dd	@@$xt$20Controls@TWinControl
	dd	0
	dd	3
	dd	0
	dd	0
	dd	0
@$xt$26Forms@TScrollingWinControl	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv	segment virtual
@@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv	proc	near
?live16452@0:
	?debug	T "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\systobj.h"
	?debug L 240
	push      ebp
	mov       ebp,esp
	add       esp,-8
	mov       dword ptr [ebp-8],edx
	mov       dword ptr [ebp-4],eax
@140:
	cmp       dword ptr [ebp-4],0
	je        short @141
	?debug L 241
	mov       eax,dword ptr [ebp-4]
	cmp       dword ptr [eax],0
	je        short @142
	?debug L 242
	mov       edx,dword ptr [ebp-4]
	mov       ecx,dword ptr [edx]
	push      ecx
	mov       eax,dword ptr [ecx]
	call      dword ptr [eax+8]
	?debug L 243
@142:
	mov       edx,dword ptr [ebp-4]
	xor       ecx,ecx
	mov       dword ptr [edx],ecx
	test      byte ptr [ebp-8],1
	je        short @143
	push      dword ptr [ebp-4]
	call      @$bdele$qpv
	pop       ecx
	?debug L 244
@143:
@141:
@144:
	pop       ecx
	pop       ecx
	pop       ebp
	ret 
	?debug L 0
@@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv	endp
@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	101
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch147
	dd	?patch148
	dd	?patch149
	df	@@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv
	dw	0
	dw	4401
	dw	0
	dw	275
	dw	0
	dw	0
	dw	0
	db	54
	db	64
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	37
	db	68
	db	101
	db	108
	db	112
	db	104
	db	105
	db	73
	db	110
	db	116
	db	101
	db	114
	db	102
	db	97
	db	99
	db	101
	db	36
	db	116
	db	49
	db	52
	db	70
	db	111
	db	114
	db	109
	db	115
	db	64
	db	73
	db	79
	db	108
	db	101
	db	70
	db	111
	db	114
	db	109
	db	37
	db	64
	db	36
	db	98
	db	100
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4393
	dw	0
	dw	276
	dw	0
	dw	0
	dw	0
	dw	?patch150
	dw	529
	dw	?patch151
	dd	?live16452@0-@@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv
	dd	?live16452@0-?live16452@0
	dw	17
?patch151	equ	1
?patch150	equ	14
?patch147	equ	@144-@@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv+4
?patch148	equ	0
?patch149	equ	@144-@@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv	segment virtual
@@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv	proc	near
?live16453@0:
	?debug L 240
	push      ebp
	mov       ebp,esp
	add       esp,-8
	mov       dword ptr [ebp-8],edx
	mov       dword ptr [ebp-4],eax
@145:
	cmp       dword ptr [ebp-4],0
	je        short @146
	?debug L 241
	mov       eax,dword ptr [ebp-4]
	cmp       dword ptr [eax],0
	je        short @147
	?debug L 242
	mov       edx,dword ptr [ebp-4]
	mov       ecx,dword ptr [edx]
	push      ecx
	mov       eax,dword ptr [ecx]
	call      dword ptr [eax+8]
	?debug L 243
@147:
	mov       edx,dword ptr [ebp-4]
	xor       ecx,ecx
	mov       dword ptr [edx],ecx
	test      byte ptr [ebp-8],1
	je        short @148
	push      dword ptr [ebp-4]
	call      @$bdele$qpv
	pop       ecx
	?debug L 244
@148:
@146:
@149:
	pop       ecx
	pop       ecx
	pop       ebp
	ret 
	?debug L 0
@@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv	endp
@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	102
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch152
	dd	?patch153
	dd	?patch154
	df	@@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv
	dw	0
	dw	4444
	dw	0
	dw	288
	dw	0
	dw	0
	dw	0
	db	55
	db	64
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	37
	db	68
	db	101
	db	108
	db	112
	db	104
	db	105
	db	73
	db	110
	db	116
	db	101
	db	114
	db	102
	db	97
	db	99
	db	101
	db	36
	db	116
	db	49
	db	53
	db	70
	db	111
	db	114
	db	109
	db	115
	db	64
	db	73
	db	68
	db	101
	db	115
	db	105
	db	103
	db	110
	db	101
	db	114
	db	37
	db	64
	db	36
	db	98
	db	100
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4436
	dw	0
	dw	289
	dw	0
	dw	0
	dw	0
	dw	?patch155
	dw	529
	dw	?patch156
	dd	?live16453@0-@@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv
	dd	?live16453@0-?live16453@0
	dw	17
?patch156	equ	1
?patch155	equ	14
?patch152	equ	@149-@@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv+4
?patch153	equ	0
?patch154	equ	@149-@@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@$xt$20Controls@TWinControl	segment virtual
	align	2
@@$xt$20Controls@TWinControl	label	byte
	dd	496
	dw	3
	dw	48
	dd	0
	dd	183
	dw	72
	dw	88
	dd	0
	dw	0
	dw	0
	dd	0
	dd	9
	dd	9
	dd	@@Controls@TWinControl@$bdtr$qqrv
	dw	3
	dw	92
	db	67
	db	111
	db	110
	db	116
	db	114
	db	111
	db	108
	db	115
	db	58
	db	58
	db	84
	db	87
	db	105
	db	110
	db	67
	db	111
	db	110
	db	116
	db	114
	db	111
	db	108
	db	0
	db	0
	db	0
	dd	@@$xt$17Controls@TControl
	dd	0
	dd	3
	dd	0
	dd	0
	dd	@@$xt$49System@%DelphiInterface$t21Controls@IDockManager%
	dd	328
	dd	@@$xt$17System@AnsiString
	dd	344
	dd	0
@$xt$20Controls@TWinControl	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$49System@%DelphiInterface$t21Controls@IDockManager%	segment virtual
	align	2
@@$xt$49System@%DelphiInterface$t21Controls@IDockManager%	label	byte
	dd	4
	dw	3
	dw	48
	dd	-1
	dd	3
	dw	96
	dw	100
	dd	0
	dw	0
	dw	0
	dd	0
	dd	1
	dd	1
	dd	@@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv
	dw	3
	dw	104
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	58
	db	58
	db	68
	db	101
	db	108
	db	112
	db	104
	db	105
	db	73
	db	110
	db	116
	db	101
	db	114
	db	102
	db	97
	db	99
	db	101
	db	60
	db	67
	db	111
	db	110
	db	116
	db	114
	db	111
	db	108
	db	115
	db	58
	db	58
	db	73
	db	68
	db	111
	db	99
	db	107
	db	77
	db	97
	db	110
	db	97
	db	103
	db	101
	db	114
	db	62
	db	0
	dd	0
	dd	0
	dd	0
@$xt$49System@%DelphiInterface$t21Controls@IDockManager%	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$17Controls@TControl	segment virtual
	align	2
@@$xt$17Controls@TControl	label	byte
	dd	288
	dw	3
	dw	48
	dd	0
	dd	183
	dw	68
	dw	84
	dd	0
	dw	0
	dw	0
	dd	0
	dd	6
	dd	6
	dd	@@Controls@TControl@$bdtr$qqrv
	dw	3
	dw	88
	db	67
	db	111
	db	110
	db	116
	db	114
	db	111
	db	108
	db	115
	db	58
	db	58
	db	84
	db	67
	db	111
	db	110
	db	116
	db	114
	db	111
	db	108
	db	0
	db	0
	dd	@@$xt$18Classes@TComponent
	dd	0
	dd	3
	dd	0
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	112
	dd	0
@$xt$17Controls@TControl	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv	segment virtual
@@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv	proc	near
?live16457@0:
	?debug L 240
	push      ebp
	mov       ebp,esp
	add       esp,-8
	mov       dword ptr [ebp-8],edx
	mov       dword ptr [ebp-4],eax
@150:
	cmp       dword ptr [ebp-4],0
	je        short @151
	?debug L 241
	mov       eax,dword ptr [ebp-4]
	cmp       dword ptr [eax],0
	je        short @152
	?debug L 242
	mov       edx,dword ptr [ebp-4]
	mov       ecx,dword ptr [edx]
	push      ecx
	mov       eax,dword ptr [ecx]
	call      dword ptr [eax+8]
	?debug L 243
@152:
	mov       edx,dword ptr [ebp-4]
	xor       ecx,ecx
	mov       dword ptr [edx],ecx
	test      byte ptr [ebp-8],1
	je        short @153
	push      dword ptr [ebp-4]
	call      @$bdele$qpv
	pop       ecx
	?debug L 244
@153:
@151:
@154:
	pop       ecx
	pop       ecx
	pop       ebp
	ret 
	?debug L 0
@@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv	endp
@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv	ends
_TEXT	ends
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	108
	dw	517
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dw	0
	dd	?patch157
	dd	?patch158
	dd	?patch159
	df	@@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv
	dw	0
	dw	4487
	dw	0
	dw	301
	dw	0
	dw	0
	dw	0
	db	61
	db	64
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	64
	db	37
	db	68
	db	101
	db	108
	db	112
	db	104
	db	105
	db	73
	db	110
	db	116
	db	101
	db	114
	db	102
	db	97
	db	99
	db	101
	db	36
	db	116
	db	50
	db	49
	db	67
	db	111
	db	110
	db	116
	db	114
	db	111
	db	108
	db	115
	db	64
	db	73
	db	68
	db	111
	db	99
	db	107
	db	77
	db	97
	db	110
	db	97
	db	103
	db	101
	db	114
	db	37
	db	64
	db	36
	db	98
	db	100
	db	116
	db	114
	db	36
	db	113
	db	113
	db	114
	db	118
	dw	18
	dw	512
	dw	65532
	dw	65535
	dw	4479
	dw	0
	dw	302
	dw	0
	dw	0
	dw	0
	dw	?patch160
	dw	529
	dw	?patch161
	dd	?live16457@0-@@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv
	dd	?live16457@0-?live16457@0
	dw	17
?patch161	equ	1
?patch160	equ	14
?patch157	equ	@154-@@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv+4
?patch158	equ	0
?patch159	equ	@154-@@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv
	dw	2
	dw	6
	dw	4
	dw	531
	dw	0
$$BSYMS	ends
_TEXT	segment dword public use32 'CODE'
@$xt$18Classes@TComponent	segment virtual
	align	2
@@$xt$18Classes@TComponent	label	byte
	dd	36
	dw	3
	dw	48
	dd	0
	dd	183
	dw	68
	dw	84
	dd	0
	dw	0
	dw	0
	dd	0
	dd	4
	dd	4
	dd	@@Classes@TComponent@$bdtr$qqrv
	dw	3
	dw	88
	db	67
	db	108
	db	97
	db	115
	db	115
	db	101
	db	115
	db	58
	db	58
	db	84
	db	67
	db	111
	db	109
	db	112
	db	111
	db	110
	db	101
	db	110
	db	116
	db	0
	dd	@@$xt$19Classes@TPersistent
	dd	0
	dd	3
	dd	0
	dd	0
	dd	@@$xt$17System@AnsiString
	dd	8
	dd	0
@$xt$18Classes@TComponent	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$19Classes@TPersistent	segment virtual
	align	2
@@$xt$19Classes@TPersistent	label	byte
	dd	4
	dw	3
	dw	48
	dd	0
	dd	183
	dw	72
	dw	88
	dd	0
	dw	0
	dw	0
	dd	0
	dd	2
	dd	2
	dd	@@Classes@TPersistent@$bdtr$qqrv
	dw	3
	dw	92
	db	67
	db	108
	db	97
	db	115
	db	115
	db	101
	db	115
	db	58
	db	58
	db	84
	db	80
	db	101
	db	114
	db	115
	db	105
	db	115
	db	116
	db	101
	db	110
	db	116
	db	0
	db	0
	db	0
	db	0
	dd	@@$xt$14System@TObject
	dd	0
	dd	3
	dd	0
	dd	0
	dd	0
@$xt$19Classes@TPersistent	ends
_TEXT	ends
_TEXT	segment dword public use32 'CODE'
@$xt$14System@TObject	segment virtual
	align	2
@@$xt$14System@TObject	label	byte
	dd	4
	dw	3
	dw	48
	dd	0
	dd	179
	dw	64
	dw	68
	dd	0
	dw	0
	dw	0
	dd	0
	dd	1
	dd	1
	dd	@@System@TObject@$bdtr$qqrv
	dw	3
	dw	72
	db	83
	db	121
	db	115
	db	116
	db	101
	db	109
	db	58
	db	58
	db	84
	db	79
	db	98
	db	106
	db	101
	db	99
	db	116
	db	0
	dd	0
	dd	0
	dd	0
@$xt$14System@TObject	ends
_TEXT	ends
_DATA	segment dword public use32 'DATA'
s@	label	byte
	;	s@+0:
	db	"   **********2",10
	;	s@+15:
	db	"   *         *",10
	;	s@+30:
	db	"   *         *",10
	;	s@+45:
	db	"   *         *",10
	;	s@+60:
	db	"   1**********",0
	;	s@+75:
	db	"50",0
	;	s@+78:
	db	"30",0
	;	s@+81:
	db	"500",0
	;	s@+85:
	db	"400",0
	;	s@+89:
	db	"300",0
	;	s@+93:
	db	"10",0
	;	s@+96:
	db	"20",0
	;	s@+99:
	db	"100",0
	;	s@+103:
	db	"200",0
	;	s@+107:
	db	"50",0
	;	s@+110:
	db	"Figura ",10
	;	s@+118:
	db	"Desenhada",0
	;	s@+128:
	db	"Figura Desenhada",0
	;	s@+145:
	db	"Figura Desenhada",0
	;	s@+162:
	db	"Figura Desenhada",0
	;	s@+179:
	db	"Figura Desenhada",0
	;	s@+196:
	db	"Figura Desenhada",0
	;	s@+213:
	db	"Erro na defini",231,227
	;	s@+229:
	db	"o",10
	;	s@+231:
	db	"dos pontos da figura",0
	;	s@+252:
	db	"   **********2",10
	;	s@+267:
	db	"   *         *",10
	;	s@+282:
	db	"   *         *",10
	;	s@+297:
	db	"   *         *",10
	;	s@+312:
	db	"   1**********",0
	;	s@+327:
	db	"      *  2",10
	;	s@+338:
	db	"     * *  ",10
	;	s@+349:
	db	"    *   * ",10
	;	s@+360:
	db	"   1******",0
	;	s@+371:
	db	"     * 2",10
	;	s@+380:
	db	"    * * ",10
	;	s@+389:
	db	"   *   *",10
	;	s@+398:
	db	"    * * ",10
	;	s@+407:
	db	"   1 *  ",0
	;	s@+416:
	db	"       3*********2",10
	;	s@+435:
	db	"      *         * ",10
	;	s@+454:
	db	"     *         *  ",10
	;	s@+473:
	db	"    *         *   ",10
	;	s@+492:
	db	"   1**********    ",0
	;	s@+511:
	db	"       ******3   2",10
	;	s@+530:
	db	"      *       *   ",10
	;	s@+549:
	db	"     *         *  ",10
	;	s@+568:
	db	"    *           * ",10
	;	s@+587:
	db	"   1**************",0
	;	s@+606:
	db	"   **********3 2",10
	;	s@+623:
	db	"    *         * ",10
	;	s@+640:
	db	"     *         *",10
	;	s@+657:
	db	"    *         * ",10
	;	s@+674:
	db	"   1**********  ",0,0
	;	s@+692:
	db	"N",227
	;	s@+694:
	db	"o Implementado!!!...",0
	;	s@+715:
	db	"N",227
	;	s@+717:
	db	"o Implementado!!!...",0
	;	s@+738:
	db	"N",227
	;	s@+740:
	db	"o Implementado!!!...",0
	;	s@+761:
	db	"N",227
	;	s@+763:
	db	"o Implementado!!!...",0
	align	4
_DATA	ends
_TEXT	segment dword public use32 'CODE'
_TEXT	ends
 ?debug  C FB04084054466F726D314004000000
 ?debug  C FB040C40247870243654466F726D3104000000
 ?debug  C FB040D40466F726D734054466F726D4004000000
 ?debug  C FB0411404578746374726C734054496D6167654004000000
 ?debug  C FB0411404578746374726C73405450616E656C4004000000
 ?debug  C FB041140427574746F6E73405442697442746E4004000000
 ?debug  C FB0414405374646374726C734054436F6D626F426F784004000000
 ?debug  C FB0414405374646374726C73405447726F7570426F784004000000
 ?debug  C FB0411405374646374726C7340544C6162656C4004000000
 ?debug  C FB0410405374646374726C734054456469744004000000
 ?debug  C FB0416404578746374726C734054526164696F47726F75704004000000
 ?debug  C FB0417405374646374726C734054526164696F427574746F6E4004000000
 ?debug  C FB041240247870243131466F726D734054466F726D04000000
 ?debug  C FB045140436C61737365734054436F6D706F6E656E744055706461746552656769737472792471717270313753797374656D40544D657461436C6173736F78313753797374656D40416E7369537472696E67743302000000
 ?debug  C FB041440436C61737365734054436F6D706F6E656E744004000000
	publicdll	_Form1
@@Extctrls@TImage@GetCanvas$qqrv equ @Extctrls@TImage@GetCanvas$qqrv
 extrn   @Extctrls@TImage@GetCanvas$qqrv:near
@@Graphics@TCanvas@FloodFill$qqrii15Graphics@TColor19Graphics@TFillStyle equ @Graphics@TCanvas@FloodFill$qqrii15Graphics@TColor19Graphics@TFillStyle
 extrn   @Graphics@TCanvas@FloodFill$qqrii15Graphics@TColor19Graphics@TFillStyle:near
@@Controls@TControl@SetText$qqrx17System@AnsiString equ @Controls@TControl@SetText$qqrx17System@AnsiString
 extrn   @Controls@TControl@SetText$qqrx17System@AnsiString:near
@@System@AnsiString@$bctr$qqrpxc equ @System@AnsiString@$bctr$qqrpxc
 extrn   @System@AnsiString@$bctr$qqrpxc:near
@@System@AnsiString@$bdtr$qqrv equ @System@AnsiString@$bdtr$qqrv
 extrn   @System@AnsiString@$bdtr$qqrv:near
@@Stdctrls@TCustomComboBox@SetItemIndex$qqri equ @Stdctrls@TCustomComboBox@SetItemIndex$qqri
 extrn   @Stdctrls@TCustomComboBox@SetItemIndex$qqri:near
 extrn   __Exception_list:dword
 extrn   @__InitExceptBlockLDTC:near
 extrn   __ClassCreate:near
 extrn   __AfterConstruction:near
 extrn   @$bnew$qui:near
@@Graphics@TCanvas@FillRect$qqrrx13Windows@TRect equ @Graphics@TCanvas@FillRect$qqrrx13Windows@TRect
 extrn   @Graphics@TCanvas@FillRect$qqrrx13Windows@TRect:near
 extrn   @$bdele$qpv:near
@@Controls@TControl@GetText$qqrv equ @Controls@TControl@GetText$qqrv
 extrn   @Controls@TControl@GetText$qqrv:near
@@Stdctrls@TCustomComboBox@GetItemIndex$qqrv equ @Stdctrls@TCustomComboBox@GetItemIndex$qqrv
 extrn   @Stdctrls@TCustomComboBox@GetItemIndex$qqrv:near
@@System@AnsiString@ToInt$xqqrv equ @System@AnsiString@ToInt$xqqrv
 extrn   @System@AnsiString@ToInt$xqqrv:near
@@Controls@TControl@SetVisible$qqro equ @Controls@TControl@SetVisible$qqro
 extrn   @Controls@TControl@SetVisible$qqro:near
@@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor equ @Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
 extrn   @Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor:near
@@Graphics@TCanvas@TextOutA$qqriix17System@AnsiString equ @Graphics@TCanvas@TextOutA$qqriix17System@AnsiString
 extrn   @Graphics@TCanvas@TextOutA$qqriix17System@AnsiString:near
@@Forms@TCustomForm@$bctr$qqrp18Classes@TComponent equ @Forms@TCustomForm@$bctr$qqrp18Classes@TComponent
 extrn   @Forms@TCustomForm@$bctr$qqrp18Classes@TComponent:near
 extrn   @Forms@TForm@:byte
@@Classes@TComponent@SafeCallException$qqrp14System@TObjectpv equ @Classes@TComponent@SafeCallException$qqrp14System@TObjectpv
 extrn   @Classes@TComponent@SafeCallException$qqrp14System@TObjectpv:near
@@Forms@TCustomForm@AfterConstruction$qqrv equ @Forms@TCustomForm@AfterConstruction$qqrv
 extrn   @Forms@TCustomForm@AfterConstruction$qqrv:near
@@Forms@TCustomForm@BeforeDestruction$qqrv equ @Forms@TCustomForm@BeforeDestruction$qqrv
 extrn   @Forms@TCustomForm@BeforeDestruction$qqrv:near
@@System@TObject@Dispatch$qqrpv equ @System@TObject@Dispatch$qqrpv
 extrn   @System@TObject@Dispatch$qqrpv:near
@@Forms@TCustomForm@DefaultHandler$qqrpv equ @Forms@TCustomForm@DefaultHandler$qqrpv
 extrn   @Forms@TCustomForm@DefaultHandler$qqrpv:near
@@System@TObject@NewInstance$qqrp17System@TMetaClass equ @System@TObject@NewInstance$qqrp17System@TMetaClass
 extrn   @System@TObject@NewInstance$qqrp17System@TMetaClass:near
@@System@TObject@FreeInstance$qqrv equ @System@TObject@FreeInstance$qqrv
 extrn   @System@TObject@FreeInstance$qqrv:near
@@Controls@TWinControl@AssignTo$qqrp19Classes@TPersistent equ @Controls@TWinControl@AssignTo$qqrp19Classes@TPersistent
 extrn   @Controls@TWinControl@AssignTo$qqrp19Classes@TPersistent:near
@@Forms@TCustomForm@DefineProperties$qqrp14Classes@TFiler equ @Forms@TCustomForm@DefineProperties$qqrp14Classes@TFiler
 extrn   @Forms@TCustomForm@DefineProperties$qqrp14Classes@TFiler:near
@@Classes@TPersistent@Assign$qqrp19Classes@TPersistent equ @Classes@TPersistent@Assign$qqrp19Classes@TPersistent
 extrn   @Classes@TPersistent@Assign$qqrp19Classes@TPersistent:near
@@Forms@TCustomForm@Loaded$qqrv equ @Forms@TCustomForm@Loaded$qqrv
 extrn   @Forms@TCustomForm@Loaded$qqrv:near
@@Forms@TCustomForm@Notification$qqrp18Classes@TComponent18Classes@TOperation equ @Forms@TCustomForm@Notification$qqrp18Classes@TComponent18Classes@TOperation
 extrn   @Forms@TCustomForm@Notification$qqrp18Classes@TComponent18Classes@TOperation:near
@@Forms@TCustomForm@ReadState$qqrp15Classes@TReader equ @Forms@TCustomForm@ReadState$qqrp15Classes@TReader
 extrn   @Forms@TCustomForm@ReadState$qqrp15Classes@TReader:near
@@Controls@TControl@SetName$qqrx17System@AnsiString equ @Controls@TControl@SetName$qqrx17System@AnsiString
 extrn   @Controls@TControl@SetName$qqrx17System@AnsiString:near
@@Forms@TCustomForm@ValidateRename$qqrp18Classes@TComponentx17System@AnsiStringt2 equ @Forms@TCustomForm@ValidateRename$qqrp18Classes@TComponentx17System@AnsiStringt2
 extrn   @Forms@TCustomForm@ValidateRename$qqrp18Classes@TComponentx17System@AnsiStringt2:near
@@Classes@TComponent@WriteState$qqrp15Classes@TWriter equ @Classes@TComponent@WriteState$qqrp15Classes@TWriter
 extrn   @Classes@TComponent@WriteState$qqrp15Classes@TWriter:near
@@Forms@TCustomForm@QueryInterface$qqsrx5_GUIDpv equ @Forms@TCustomForm@QueryInterface$qqsrx5_GUIDpv
 extrn   @Forms@TCustomForm@QueryInterface$qqsrx5_GUIDpv:near
@@Controls@TWinControl@CanResize$qqrrit1 equ @Controls@TWinControl@CanResize$qqrrit1
 extrn   @Controls@TWinControl@CanResize$qqrrit1:near
@@Controls@TWinControl@CanAutoSize$qqrrit1 equ @Controls@TWinControl@CanAutoSize$qqrrit1
 extrn   @Controls@TWinControl@CanAutoSize$qqrrit1:near
@@Controls@TWinControl@ConstrainedResize$qqrrit1t1t1 equ @Controls@TWinControl@ConstrainedResize$qqrrit1t1t1
 extrn   @Controls@TWinControl@ConstrainedResize$qqrrit1t1t1:near
@@Controls@TWinControl@GetClientOrigin$qqrv equ @Controls@TWinControl@GetClientOrigin$qqrv
 extrn   @Controls@TWinControl@GetClientOrigin$qqrv:near
@@Forms@TCustomForm@GetClientRect$qqrv equ @Forms@TCustomForm@GetClientRect$qqrv
 extrn   @Forms@TCustomForm@GetClientRect$qqrv:near
@@Controls@TWinControl@GetDeviceContext$qqrrpv equ @Controls@TWinControl@GetDeviceContext$qqrrpv
 extrn   @Controls@TWinControl@GetDeviceContext$qqrrpv:near
@@Controls@TControl@GetDragImages$qqrv equ @Controls@TControl@GetDragImages$qqrv
 extrn   @Controls@TControl@GetDragImages$qqrv:near
@@Controls@TControl@GetEnabled$qqrv equ @Controls@TControl@GetEnabled$qqrv
 extrn   @Controls@TControl@GetEnabled$qqrv:near
@@Forms@TCustomForm@GetFloating$qqrv equ @Forms@TCustomForm@GetFloating$qqrv
 extrn   @Forms@TCustomForm@GetFloating$qqrv:near
@@Controls@TControl@GetFloatingDockSiteClass$qqrv equ @Controls@TControl@GetFloatingDockSiteClass$qqrv
 extrn   @Controls@TControl@GetFloatingDockSiteClass$qqrv:near
@@Controls@TControl@SetDragMode$qqr18Controls@TDragMode equ @Controls@TControl@SetDragMode$qqr18Controls@TDragMode
 extrn   @Controls@TControl@SetDragMode$qqr18Controls@TDragMode:near
@@Controls@TControl@SetEnabled$qqro equ @Controls@TControl@SetEnabled$qqro
 extrn   @Controls@TControl@SetEnabled$qqro:near
@@Forms@TCustomForm@SetParent$qqrp20Controls@TWinControl equ @Forms@TCustomForm@SetParent$qqrp20Controls@TWinControl
 extrn   @Forms@TCustomForm@SetParent$qqrp20Controls@TWinControl:near
@@Forms@TCustomForm@SetParentBiDiMode$qqro equ @Forms@TCustomForm@SetParentBiDiMode$qqro
 extrn   @Forms@TCustomForm@SetParentBiDiMode$qqro:near
@@Controls@TControl@SetBiDiMode$qqr17Classes@TBiDiMode equ @Controls@TControl@SetBiDiMode$qqr17Classes@TBiDiMode
 extrn   @Controls@TControl@SetBiDiMode$qqr17Classes@TBiDiMode:near
@@Forms@TCustomForm@WndProc$qqrr17Messages@TMessage equ @Forms@TCustomForm@WndProc$qqrr17Messages@TMessage
 extrn   @Forms@TCustomForm@WndProc$qqrr17Messages@TMessage:near
@@Controls@TControl@InitiateAction$qqrv equ @Controls@TControl@InitiateAction$qqrv
 extrn   @Controls@TControl@InitiateAction$qqrv:near
@@Controls@TWinControl@Invalidate$qqrv equ @Controls@TWinControl@Invalidate$qqrv
 extrn   @Controls@TWinControl@Invalidate$qqrv:near
@@Controls@TWinControl@Repaint$qqrv equ @Controls@TWinControl@Repaint$qqrv
 extrn   @Controls@TWinControl@Repaint$qqrv:near
@@Controls@TWinControl@SetBounds$qqriiii equ @Controls@TWinControl@SetBounds$qqriiii
 extrn   @Controls@TWinControl@SetBounds$qqriiii:near
@@Controls@TWinControl@Update$qqrv equ @Controls@TWinControl@Update$qqrv
 extrn   @Controls@TWinControl@Update$qqrv:near
@@Forms@TScrollingWinControl@AdjustClientRect$qqrr13Windows@TRect equ @Forms@TScrollingWinControl@AdjustClientRect$qqrr13Windows@TRect
 extrn   @Forms@TScrollingWinControl@AdjustClientRect$qqrr13Windows@TRect:near
@@Forms@TCustomForm@AlignControls$qqrp17Controls@TControlr13Windows@TRect equ @Forms@TCustomForm@AlignControls$qqrp17Controls@TControlr13Windows@TRect
 extrn   @Forms@TCustomForm@AlignControls$qqrp17Controls@TControlr13Windows@TRect:near
@@Controls@TWinControl@CreateHandle$qqrv equ @Controls@TWinControl@CreateHandle$qqrv
 extrn   @Controls@TWinControl@CreateHandle$qqrv:near
@@Forms@TCustomForm@CreateParams$qqrr22Controls@TCreateParams equ @Forms@TCustomForm@CreateParams$qqrr22Controls@TCreateParams
 extrn   @Forms@TCustomForm@CreateParams$qqrr22Controls@TCreateParams:near
@@Forms@TCustomForm@CreateWindowHandle$qqrrx22Controls@TCreateParams equ @Forms@TCustomForm@CreateWindowHandle$qqrrx22Controls@TCreateParams
 extrn   @Forms@TCustomForm@CreateWindowHandle$qqrrx22Controls@TCreateParams:near
@@Forms@TCustomForm@CreateWnd$qqrv equ @Forms@TCustomForm@CreateWnd$qqrv
 extrn   @Forms@TCustomForm@CreateWnd$qqrv:near
@@Forms@TCustomForm@DestroyWindowHandle$qqrv equ @Forms@TCustomForm@DestroyWindowHandle$qqrv
 extrn   @Forms@TCustomForm@DestroyWindowHandle$qqrv:near
@@Controls@TWinControl@DestroyWnd$qqrv equ @Controls@TWinControl@DestroyWnd$qqrv
 extrn   @Controls@TWinControl@DestroyWnd$qqrv:near
@@Controls@TWinControl@GetControlExtents$qqrv equ @Controls@TWinControl@GetControlExtents$qqrv
 extrn   @Controls@TWinControl@GetControlExtents$qqrv:near
@@Forms@TCustomForm@PaintWindow$qqrpv equ @Forms@TCustomForm@PaintWindow$qqrpv
 extrn   @Forms@TCustomForm@PaintWindow$qqrpv:near
@@Controls@TWinControl@ShowControl$qqrp17Controls@TControl equ @Controls@TWinControl@ShowControl$qqrp17Controls@TControl
 extrn   @Controls@TWinControl@ShowControl$qqrp17Controls@TControl:near
@@Forms@TCustomForm@SetFocus$qqrv equ @Forms@TCustomForm@SetFocus$qqrv
 extrn   @Forms@TCustomForm@SetFocus$qqrv:near
@@Forms@TScrollingWinControl@AutoScrollEnabled$qqrv equ @Forms@TScrollingWinControl@AutoScrollEnabled$qqrv
 extrn   @Forms@TScrollingWinControl@AutoScrollEnabled$qqrv:near
@@Forms@TScrollingWinControl@AutoScrollInView$qqrp17Controls@TControl equ @Forms@TScrollingWinControl@AutoScrollInView$qqrp17Controls@TControl
 extrn   @Forms@TScrollingWinControl@AutoScrollInView$qqrp17Controls@TControl:near
@@Forms@TCustomForm@Resizing$qqr18Forms@TWindowState equ @Forms@TCustomForm@Resizing$qqr18Forms@TWindowState
 extrn   @Forms@TCustomForm@Resizing$qqr18Forms@TWindowState:near
@@Forms@TCustomForm@DoCreate$qqrv equ @Forms@TCustomForm@DoCreate$qqrv
 extrn   @Forms@TCustomForm@DoCreate$qqrv:near
@@Forms@TCustomForm@DoDestroy$qqrv equ @Forms@TCustomForm@DoDestroy$qqrv
 extrn   @Forms@TCustomForm@DoDestroy$qqrv:near
@@Forms@TCustomForm@UpdateActions$qqrv equ @Forms@TCustomForm@UpdateActions$qqrv
 extrn   @Forms@TCustomForm@UpdateActions$qqrv:near
@@Forms@TCustomForm@CloseQuery$qqrv equ @Forms@TCustomForm@CloseQuery$qqrv
 extrn   @Forms@TCustomForm@CloseQuery$qqrv:near
@@Forms@TCustomForm@SetFocusedControl$qqrp20Controls@TWinControl equ @Forms@TCustomForm@SetFocusedControl$qqrp20Controls@TWinControl
 extrn   @Forms@TCustomForm@SetFocusedControl$qqrp20Controls@TWinControl:near
@@Forms@TCustomForm@ShowModal$qqrv equ @Forms@TCustomForm@ShowModal$qqrv
 extrn   @Forms@TCustomForm@ShowModal$qqrv:near
@@Forms@TCustomForm@WantChildKey$qqrp17Controls@TControlr17Messages@TMessage equ @Forms@TCustomForm@WantChildKey$qqrp17Controls@TControlr17Messages@TMessage
 extrn   @Forms@TCustomForm@WantChildKey$qqrp17Controls@TControlr17Messages@TMessage:near
 extrn   @Extctrls@TImage@:byte
 extrn   @Extctrls@TPanel@:byte
 extrn   @Buttons@TBitBtn@:byte
 extrn   @Stdctrls@TComboBox@:byte
 extrn   @Stdctrls@TGroupBox@:byte
 extrn   @Stdctrls@TLabel@:byte
 extrn   @Stdctrls@TEdit@:byte
 extrn   @Extctrls@TRadioGroup@:byte
 extrn   @Stdctrls@TRadioButton@:byte
 extrn   @$xp$11Forms@TForm:byte
 extrn   __BeforeDestruction:near
 extrn   __ClassDestroy:near
@@System@AnsiString@$bctr$qqrrx17System@AnsiString equ @System@AnsiString@$bctr$qqrrx17System@AnsiString
 extrn   @System@AnsiString@$bctr$qqrrx17System@AnsiString:near
@@Classes@TComponent@UpdateRegistry$qqrp17System@TMetaClassox17System@AnsiStringt3 equ @Classes@TComponent@UpdateRegistry$qqrp17System@TMetaClassox17System@AnsiStringt3
 extrn   @Classes@TComponent@UpdateRegistry$qqrp17System@TMetaClassox17System@AnsiStringt3:near
 extrn   @Classes@TComponent@:byte
@@Forms@TCustomForm@$bctr$qqrp18Classes@TComponenti equ @Forms@TCustomForm@$bctr$qqrp18Classes@TComponenti
 extrn   @Forms@TCustomForm@$bctr$qqrp18Classes@TComponenti:near
@@Forms@TCustomForm@$bdtr$qqrv equ @Forms@TCustomForm@$bdtr$qqrv
 extrn   @Forms@TCustomForm@$bdtr$qqrv:near
@@Forms@TScrollingWinControl@$bdtr$qqrv equ @Forms@TScrollingWinControl@$bdtr$qqrv
 extrn   @Forms@TScrollingWinControl@$bdtr$qqrv:near
@@Controls@TWinControl@$bdtr$qqrv equ @Controls@TWinControl@$bdtr$qqrv
 extrn   @Controls@TWinControl@$bdtr$qqrv:near
@@Controls@TControl@$bdtr$qqrv equ @Controls@TControl@$bdtr$qqrv
 extrn   @Controls@TControl@$bdtr$qqrv:near
@@Classes@TComponent@$bdtr$qqrv equ @Classes@TComponent@$bdtr$qqrv
 extrn   @Classes@TComponent@$bdtr$qqrv:near
@@Classes@TPersistent@$bdtr$qqrv equ @Classes@TPersistent@$bdtr$qqrv
 extrn   @Classes@TPersistent@$bdtr$qqrv:near
@@System@TObject@$bdtr$qqrv equ @System@TObject@$bdtr$qqrv
 extrn   @System@TObject@$bdtr$qqrv:near
 ?debug  C FB0976657273616F325F302E64666D00
 ?debug  C FB0A76657273616F325F3000
 ?debug  C 9F76636C6535302E6C6962
$$BSYMS	segment byte public use32 'DEBSYM'
	dw	22
	dw	514
	df	_Form1
	dw	0
	dw	4097
	dw	0
	dw	303
	dw	0
	dw	0
	dw	0
	dw	?patch162
	dw	37
	dw	304
	dw	0
	dw	0
	dw	0
	dw	0
?patch162	equ	12
	dw	?patch163
	dw	37
	dw	305
	dw	0
	dw	0
	dw	0
	dw	0
?patch163	equ	12
	dw	?patch164
	dw	3
	dw	4518
	dw	0
	dw	306
	dw	0
	dw	0
	dw	0
	dw	2
?patch164	equ	16
	dw	?patch165
	dw	3
	dw	4518
	dw	0
	dw	307
	dw	0
	dw	0
	dw	0
	dw	3
?patch165	equ	16
	dw	?patch166
	dw	3
	dw	4518
	dw	0
	dw	308
	dw	0
	dw	0
	dw	0
	dw	4
?patch166	equ	16
	dw	?patch167
	dw	3
	dw	4518
	dw	0
	dw	309
	dw	0
	dw	0
	dw	0
	dw	5
?patch167	equ	16
	dw	?patch168
	dw	3
	dw	4518
	dw	0
	dw	310
	dw	0
	dw	0
	dw	0
	dw	6
?patch168	equ	16
	dw	?patch169
	dw	3
	dw	4518
	dw	0
	dw	311
	dw	0
	dw	0
	dw	0
	dw	7
?patch169	equ	16
	dw	?patch170
	dw	3
	dw	4518
	dw	0
	dw	312
	dw	0
	dw	0
	dw	0
	dw	8
?patch170	equ	16
	dw	?patch171
	dw	3
	dw	4518
	dw	0
	dw	313
	dw	0
	dw	0
	dw	0
	dw	9
?patch171	equ	16
	dw	?patch172
	dw	3
	dw	4518
	dw	0
	dw	314
	dw	0
	dw	0
	dw	0
	dw	11
?patch172	equ	16
	dw	?patch173
	dw	3
	dw	4518
	dw	0
	dw	315
	dw	0
	dw	0
	dw	0
	dw	12
?patch173	equ	16
	dw	?patch174
	dw	3
	dw	4518
	dw	0
	dw	316
	dw	0
	dw	0
	dw	0
	dw	13
?patch174	equ	16
	dw	?patch175
	dw	3
	dw	4518
	dw	0
	dw	317
	dw	0
	dw	0
	dw	0
	dw	17
?patch175	equ	16
	dw	?patch176
	dw	3
	dw	4519
	dw	0
	dw	318
	dw	0
	dw	0
	dw	0
	dw	16384
?patch176	equ	16
	dw	?patch177
	dw	3
	dw	4518
	dw	0
	dw	319
	dw	0
	dw	0
	dw	0
	dw	0
?patch177	equ	16
	dw	?patch178
	dw	3
	dw	4518
	dw	0
	dw	320
	dw	0
	dw	0
	dw	0
	dw	1
?patch178	equ	16
	dw	?patch179
	dw	3
	dw	4518
	dw	0
	dw	321
	dw	0
	dw	0
	dw	0
	dw	2
?patch179	equ	16
	dw	?patch180
	dw	3
	dw	4518
	dw	0
	dw	322
	dw	0
	dw	0
	dw	0
	dw	3
?patch180	equ	16
	dw	?patch181
	dw	3
	dw	4518
	dw	0
	dw	323
	dw	0
	dw	0
	dw	0
	dw	4
?patch181	equ	16
	dw	?patch182
	dw	3
	dw	4518
	dw	0
	dw	324
	dw	0
	dw	0
	dw	0
	dw	5
?patch182	equ	16
	dw	?patch183
	dw	3
	dw	4518
	dw	0
	dw	325
	dw	0
	dw	0
	dw	0
	dw	6
?patch183	equ	16
	dw	?patch184
	dw	3
	dw	4518
	dw	0
	dw	326
	dw	0
	dw	0
	dw	0
	dw	7
?patch184	equ	16
	dw	?patch185
	dw	3
	dw	4518
	dw	0
	dw	327
	dw	0
	dw	0
	dw	0
	dw	8
?patch185	equ	16
	dw	?patch186
	dw	3
	dw	4518
	dw	0
	dw	328
	dw	0
	dw	0
	dw	0
	dw	9
?patch186	equ	16
	dw	?patch187
	dw	3
	dw	4518
	dw	0
	dw	329
	dw	0
	dw	0
	dw	0
	dw	10
?patch187	equ	16
	dw	?patch188
	dw	3
	dw	4518
	dw	0
	dw	330
	dw	0
	dw	0
	dw	0
	dw	11
?patch188	equ	16
	dw	?patch189
	dw	3
	dw	4518
	dw	0
	dw	331
	dw	0
	dw	0
	dw	0
	dw	12
?patch189	equ	16
	dw	?patch190
	dw	3
	dw	4518
	dw	0
	dw	332
	dw	0
	dw	0
	dw	0
	dw	13
?patch190	equ	16
	dw	?patch191
	dw	37
	dw	333
	dw	0
	dw	0
	dw	0
	dw	0
?patch191	equ	12
	dw	?patch192
	dw	37
	dw	334
	dw	0
	dw	0
	dw	0
	dw	0
?patch192	equ	12
	dw	?patch193
	dw	37
	dw	335
	dw	0
	dw	0
	dw	0
	dw	0
?patch193	equ	12
	dw	?patch194
	dw	37
	dw	336
	dw	0
	dw	0
	dw	0
	dw	0
?patch194	equ	12
	dw	?patch195
	dw	37
	dw	337
	dw	0
	dw	0
	dw	0
	dw	0
?patch195	equ	12
	dw	?patch196
	dw	37
	dw	338
	dw	0
	dw	0
	dw	0
	dw	0
?patch196	equ	12
	dw	?patch197
	dw	37
	dw	339
	dw	0
	dw	0
	dw	0
	dw	0
?patch197	equ	12
	dw	?patch198
	dw	3
	dw	4520
	dw	0
	dw	340
	dw	0
	dw	0
	dw	0
	dw	0
?patch198	equ	16
	dw	?patch199
	dw	3
	dw	4520
	dw	0
	dw	341
	dw	0
	dw	0
	dw	0
	dw	255
?patch199	equ	16
	dw	?patch200
	dw	3
	dw	4520
	dw	0
	dw	342
	dw	0
	dw	0
	dw	0
	dw	32772
	dw	0
	dw	255
?patch200	equ	20
	dw	?patch201
	dw	3
	dw	4520
	dw	0
	dw	343
	dw	0
	dw	0
	dw	0
	dw	32772
	dw	65535
	dw	255
?patch201	equ	20
	dw	?patch202
	dw	37
	dw	344
	dw	0
	dw	0
	dw	0
	dw	0
?patch202	equ	12
	dw	?patch203
	dw	37
	dw	345
	dw	0
	dw	0
	dw	0
	dw	0
?patch203	equ	12
	dw	?patch204
	dw	37
	dw	346
	dw	0
	dw	0
	dw	0
	dw	0
?patch204	equ	12
	dw	?patch205
	dw	37
	dw	347
	dw	0
	dw	0
	dw	0
	dw	0
?patch205	equ	12
	dw	?patch206
	dw	37
	dw	348
	dw	0
	dw	0
	dw	0
	dw	0
?patch206	equ	12
	dw	?patch207
	dw	37
	dw	349
	dw	0
	dw	0
	dw	0
	dw	0
?patch207	equ	12
	dw	?patch208
	dw	37
	dw	350
	dw	0
	dw	0
	dw	0
	dw	0
?patch208	equ	12
	dw	?patch209
	dw	37
	dw	351
	dw	0
	dw	0
	dw	0
	dw	0
?patch209	equ	12
	dw	?patch210
	dw	37
	dw	352
	dw	0
	dw	0
	dw	0
	dw	0
?patch210	equ	12
	dw	?patch211
	dw	37
	dw	353
	dw	0
	dw	0
	dw	0
	dw	0
?patch211	equ	12
	dw	?patch212
	dw	37
	dw	354
	dw	0
	dw	0
	dw	0
	dw	0
?patch212	equ	12
	dw	?patch213
	dw	37
	dw	355
	dw	0
	dw	0
	dw	0
	dw	0
?patch213	equ	12
	dw	?patch214
	dw	37
	dw	356
	dw	0
	dw	0
	dw	0
	dw	0
?patch214	equ	12
	dw	?patch215
	dw	37
	dw	357
	dw	0
	dw	0
	dw	0
	dw	0
?patch215	equ	12
	dw	?patch216
	dw	37
	dw	358
	dw	0
	dw	0
	dw	0
	dw	0
?patch216	equ	12
	dw	?patch217
	dw	37
	dw	359
	dw	0
	dw	0
	dw	0
	dw	0
?patch217	equ	12
	dw	?patch218
	dw	37
	dw	360
	dw	0
	dw	0
	dw	0
	dw	0
?patch218	equ	12
	dw	?patch219
	dw	37
	dw	361
	dw	0
	dw	0
	dw	0
	dw	0
?patch219	equ	12
	dw	?patch220
	dw	37
	dw	362
	dw	0
	dw	0
	dw	0
	dw	0
?patch220	equ	12
	dw	?patch221
	dw	37
	dw	363
	dw	0
	dw	0
	dw	0
	dw	0
?patch221	equ	12
	dw	16
	dw	4
	dw	4109
	dw	0
	dw	1
	dw	364
	dw	0
	dw	0
	dw	0
	dw	16
	dw	4
	dw	4105
	dw	0
	dw	1
	dw	365
	dw	0
	dw	0
	dw	0
	dw	16
	dw	4
	dw	16
	dw	0
	dw	0
	dw	366
	dw	0
	dw	0
	dw	0
	dw	16
	dw	4
	dw	4107
	dw	0
	dw	1
	dw	367
	dw	0
	dw	0
	dw	0
	dw	16
	dw	4
	dw	4102
	dw	0
	dw	1
	dw	368
	dw	0
	dw	0
	dw	0
	dw	16
	dw	4
	dw	4098
	dw	0
	dw	1
	dw	369
	dw	0
	dw	0
	dw	0
	dw	?patch222
	dw	38
	dw	268
	dw	370
	dw	0
	dw	371
	dw	0
	dw	372
	dw	0
	dw	373
	dw	0
	dw	374
	dw	0
	dw	375
	dw	0
	dw	376
	dw	0
	dw	377
	dw	0
	dw	378
	dw	0
	dw	379
	dw	0
	dw	380
	dw	0
	dw	381
	dw	0
	dw	382
	dw	0
	dw	383
	dw	0
	dw	384
	dw	0
	dw	385
	dw	0
	dw	386
	dw	0
	dw	387
	dw	0
	dw	388
	dw	0
	dw	389
	dw	0
	dw	390
	dw	0
	dw	391
	dw	0
	dw	392
	dw	0
	dw	393
	dw	0
	dw	394
	dw	0
	dw	395
	dw	0
	dw	396
	dw	0
	dw	397
	dw	0
	dw	398
	dw	0
	dw	399
	dw	0
	dw	400
	dw	0
	dw	401
	dw	0
	dw	402
	dw	0
	dw	403
	dw	0
	dw	404
	dw	0
	dw	405
	dw	0
	dw	406
	dw	0
	dw	407
	dw	0
	dw	408
	dw	0
	dw	409
	dw	0
	dw	410
	dw	0
	dw	411
	dw	0
	dw	412
	dw	0
	dw	413
	dw	0
	dw	414
	dw	0
	dw	415
	dw	0
	dw	416
	dw	0
	dw	417
	dw	0
	dw	418
	dw	0
	dw	419
	dw	0
	dw	420
	dw	0
	dw	421
	dw	0
	dw	422
	dw	0
	dw	423
	dw	0
	dw	424
	dw	0
	dw	425
	dw	0
	dw	426
	dw	0
	dw	427
	dw	0
	dw	428
	dw	0
	dw	429
	dw	0
	dw	430
	dw	0
	dw	431
	dw	0
	dw	432
	dw	0
	dw	433
	dw	0
	dw	434
	dw	0
	dw	435
	dw	0
	dw	436
	dw	0
	dw	437
	dw	0
	dw	438
	dw	0
	dw	439
	dw	0
	dw	440
	dw	0
	dw	441
	dw	0
	dw	442
	dw	0
	dw	443
	dw	0
	dw	444
	dw	0
	dw	445
	dw	0
	dw	446
	dw	0
	dw	447
	dw	0
	dw	448
	dw	0
	dw	449
	dw	0
	dw	450
	dw	0
	dw	451
	dw	0
	dw	452
	dw	0
	dw	453
	dw	0
	dw	454
	dw	0
	dw	455
	dw	0
	dw	456
	dw	0
	dw	457
	dw	0
	dw	458
	dw	0
	dw	459
	dw	0
	dw	460
	dw	0
	dw	461
	dw	0
	dw	462
	dw	0
	dw	463
	dw	0
	dw	464
	dw	0
	dw	465
	dw	0
	dw	466
	dw	0
	dw	467
	dw	0
	dw	468
	dw	0
	dw	469
	dw	0
	dw	470
	dw	0
	dw	471
	dw	0
	dw	472
	dw	0
	dw	473
	dw	0
	dw	474
	dw	0
	dw	475
	dw	0
	dw	476
	dw	0
	dw	477
	dw	0
	dw	478
	dw	0
	dw	479
	dw	0
	dw	480
	dw	0
	dw	481
	dw	0
	dw	482
	dw	0
	dw	483
	dw	0
	dw	484
	dw	0
	dw	485
	dw	0
	dw	486
	dw	0
	dw	487
	dw	0
	dw	488
	dw	0
	dw	489
	dw	0
	dw	490
	dw	0
	dw	491
	dw	0
	dw	492
	dw	0
	dw	493
	dw	0
	dw	494
	dw	0
	dw	495
	dw	0
	dw	496
	dw	0
	dw	497
	dw	0
	dw	498
	dw	0
	dw	499
	dw	0
	dw	500
	dw	0
	dw	501
	dw	0
	dw	502
	dw	0
	dw	503
	dw	0
	dw	504
	dw	0
	dw	505
	dw	0
	dw	506
	dw	0
	dw	507
	dw	0
	dw	508
	dw	0
	dw	509
	dw	0
	dw	510
	dw	0
	dw	511
	dw	0
	dw	512
	dw	0
	dw	513
	dw	0
	dw	514
	dw	0
	dw	515
	dw	0
	dw	516
	dw	0
	dw	517
	dw	0
	dw	518
	dw	0
	dw	519
	dw	0
	dw	520
	dw	0
	dw	521
	dw	0
	dw	522
	dw	0
	dw	523
	dw	0
	dw	524
	dw	0
	dw	525
	dw	0
	dw	526
	dw	0
	dw	527
	dw	0
	dw	528
	dw	0
	dw	529
	dw	0
	dw	530
	dw	0
	dw	531
	dw	0
	dw	532
	dw	0
	dw	533
	dw	0
	dw	534
	dw	0
	dw	535
	dw	0
	dw	536
	dw	0
	dw	537
	dw	0
	dw	538
	dw	0
	dw	539
	dw	0
	dw	540
	dw	0
	dw	541
	dw	0
	dw	542
	dw	0
	dw	543
	dw	0
	dw	544
	dw	0
	dw	545
	dw	0
	dw	546
	dw	0
	dw	547
	dw	0
	dw	548
	dw	0
	dw	549
	dw	0
	dw	550
	dw	0
	dw	551
	dw	0
	dw	552
	dw	0
	dw	553
	dw	0
	dw	554
	dw	0
	dw	555
	dw	0
	dw	556
	dw	0
	dw	557
	dw	0
	dw	558
	dw	0
	dw	559
	dw	0
	dw	560
	dw	0
	dw	561
	dw	0
	dw	562
	dw	0
	dw	563
	dw	0
	dw	564
	dw	0
	dw	565
	dw	0
	dw	566
	dw	0
	dw	567
	dw	0
	dw	568
	dw	0
	dw	569
	dw	0
	dw	570
	dw	0
	dw	571
	dw	0
	dw	572
	dw	0
	dw	573
	dw	0
	dw	574
	dw	0
	dw	575
	dw	0
	dw	576
	dw	0
	dw	577
	dw	0
	dw	578
	dw	0
	dw	579
	dw	0
	dw	580
	dw	0
	dw	581
	dw	0
	dw	582
	dw	0
	dw	583
	dw	0
	dw	584
	dw	0
	dw	585
	dw	0
	dw	586
	dw	0
	dw	587
	dw	0
	dw	588
	dw	0
	dw	589
	dw	0
	dw	590
	dw	0
	dw	591
	dw	0
	dw	592
	dw	0
	dw	593
	dw	0
	dw	594
	dw	0
	dw	595
	dw	0
	dw	596
	dw	0
	dw	597
	dw	0
	dw	598
	dw	0
	dw	599
	dw	0
	dw	600
	dw	0
	dw	601
	dw	0
	dw	602
	dw	0
	dw	603
	dw	0
	dw	604
	dw	0
	dw	605
	dw	0
	dw	606
	dw	0
	dw	607
	dw	0
	dw	608
	dw	0
	dw	609
	dw	0
	dw	610
	dw	0
	dw	611
	dw	0
	dw	612
	dw	0
	dw	613
	dw	0
	dw	614
	dw	0
	dw	615
	dw	0
	dw	616
	dw	0
	dw	617
	dw	0
	dw	618
	dw	0
	dw	619
	dw	0
	dw	620
	dw	0
	dw	621
	dw	0
	dw	622
	dw	0
	dw	623
	dw	0
	dw	624
	dw	0
	dw	625
	dw	0
	dw	626
	dw	0
	dw	627
	dw	0
	dw	628
	dw	0
	dw	629
	dw	0
	dw	630
	dw	0
	dw	631
	dw	0
	dw	632
	dw	0
	dw	633
	dw	0
	dw	634
	dw	0
	dw	635
	dw	0
	dw	636
	dw	0
	dw	637
	dw	0
?patch222	equ	1076
	dw	?patch223
	dw	1
	db	3
	db	1
	db	0
	db	24
	db	9
	db	66
	db	67
	db	67
	db	51
	db	50
	db	32
	db	53
	db	46
	db	53
?patch223	equ	16
$$BSYMS	ends
$$BTYPES	segment byte public use32 'DEBTYP'
	db        2,0,0,0,26,0,9,0,1,16,0,0,2,16,0,0
	db        195,16,0,0,4,0,1,0,246,16,0,0,0,0,0,0
	db        8,0,2,0,10,0,2,16,0,0,28,0,4,0,40,0
	db        245,16,0,0,34,1,0,0,0,0,0,0,0,0,3,16
	db        0,0,1,0,0,0,44,3,5,0,10,0,2,0,85,8
	db        0,2,0,10,0,3,16,0,0,8,0,2,0,10,0,6
	db        16,0,0,28,0,4,0,64,0,192,16,0,0,34,1,0
	db        0,0,0,0,0,0,0,7,16,0,0,2,0,0,0,24
	db        2,7,0,10,0,5,0,85,85,5,8,0,2,0,10,0
	db        7,16,0,0,20,0,7,0,3,0,16,0,0,0,10,16
	db        0,0,0,0,0,0,3,0,0,0,48,0,4,2,3,4
	db        0,0,4,0,0,0,0,0,0,0,0,0,242,241,3,4
	db        0,0,5,0,0,0,0,0,0,0,1,0,242,241,3,4
	db        0,0,6,0,0,0,0,0,0,0,2,0,20,0,7,0
	db        11,0,16,0,0,0,12,16,0,0,0,0,0,0,7,0
	db        0,0,176,0,4,2,3,4,0,0,8,0,0,0,0,0
	db        0,0,0,0,242,241,3,4,0,0,9,0,0,0,0,0
	db        0,0,1,0,242,241,3,4,0,0,10,0,0,0,0,0
	db        0,0,2,0,242,241,3,4,0,0,11,0,0,0,0,0
	db        0,0,3,0,242,241,3,4,0,0,12,0,0,0,0,0
	db        0,0,4,0,242,241,3,4,0,0,13,0,0,0,0,0
	db        0,0,5,0,242,241,3,4,0,0,14,0,0,0,0,0
	db        0,0,6,0,242,241,3,4,0,0,15,0,0,0,0,0
	db        0,0,7,0,242,241,3,4,0,0,16,0,0,0,0,0
	db        0,0,8,0,242,241,3,4,0,0,17,0,0,0,0,0
	db        0,0,9,0,242,241,3,4,0,0,18,0,0,0,0,0
	db        0,0,10,0,20,0,7,0,4,0,16,0,0,0,14,16
	db        0,0,0,0,0,0,19,0,0,0,64,0,4,2,3,4
	db        0,0,20,0,0,0,0,0,0,0,0,0,242,241,3,4
	db        0,0,21,0,0,0,0,0,0,0,1,0,242,241,3,4
	db        0,0,22,0,0,0,0,0,0,0,2,0,242,241,3,4
	db        0,0,23,0,0,0,0,0,0,0,3,0,26,0,9,0
	db        3,0,0,0,6,16,0,0,16,16,0,0,4,0,1,0
	db        19,16,0,0,0,0,0,0,8,0,2,0,10,4,6,16
	db        0,0,8,0,2,0,42,0,18,16,0,0,8,0,1,0
	db        1,0,250,255,255,255,8,0,1,2,1,0,17,16,0,0
	db        26,0,9,0,3,0,0,0,6,16,0,0,16,16,0,0
	db        4,0,1,0,21,16,0,0,0,0,0,0,8,0,1,2
	db        1,0,249,255,255,255,26,0,9,0,249,255,255,255,6,16
	db        0,0,16,16,0,0,4,0,0,0,23,16,0,0,0,0
	db        0,0,4,0,1,2,0,0,26,0,9,0,16,0,0,0
	db        6,16,0,0,16,16,0,0,4,0,0,0,25,16,0,0
	db        0,0,0,0,4,0,1,2,0,0,26,0,9,0,3,0
	db        0,0,6,16,0,0,16,16,0,0,4,0,1,0,27,16
	db        0,0,0,0,0,0,8,0,1,2,1,0,16,0,0,0
	db        26,0,9,0,3,0,0,0,6,16,0,0,16,16,0,0
	db        4,0,1,0,29,16,0,0,0,0,0,0,8,0,1,2
	db        1,0,248,255,255,255,26,0,9,0,48,0,0,0,6,16
	db        0,0,16,16,0,0,4,0,0,0,31,16,0,0,0,0
	db        0,0,4,0,1,2,0,0,26,0,9,0,48,0,0,0
	db        6,16,0,0,16,16,0,0,4,0,0,0,33,16,0,0
	db        0,0,0,0,4,0,1,2,0,0,26,0,9,0,3,0
	db        0,0,6,16,0,0,16,16,0,0,4,0,1,0,35,16
	db        0,0,0,0,0,0,8,0,1,2,1,0,9,16,0,0
	db        26,0,9,0,3,0,0,0,6,16,0,0,16,16,0,0
	db        4,0,1,0,37,16,0,0,0,0,0,0,8,0,1,2
	db        1,0,11,16,0,0,26,0,9,0,11,16,0,0,6,16
	db        0,0,16,16,0,0,4,0,0,0,39,16,0,0,0,0
	db        0,0,4,0,1,2,0,0,26,0,9,0,3,0,0,0
	db        6,16,0,0,16,16,0,0,4,0,1,0,41,16,0,0
	db        0,0,0,0,8,0,1,2,1,0,13,16,0,0,26,0
	db        9,0,3,0,0,0,6,16,0,0,16,16,0,0,4,0
	db        1,0,43,16,0,0,0,0,0,0,8,0,1,2,1,0
	db        116,0,0,0,26,0,9,0,3,0,0,0,6,16,0,0
	db        16,16,0,0,4,0,1,0,45,16,0,0,0,0,0,0
	db        8,0,1,2,1,0,116,0,0,0,26,0,9,0,3,0
	db        0,0,6,16,0,0,16,16,0,0,4,0,1,0,47,16
	db        0,0,0,0,0,0,8,0,1,2,1,0,247,255,255,255
	db        26,0,9,0,3,0,0,0,6,16,0,0,16,16,0,0
	db        4,0,1,0,49,16,0,0,0,0,0,0,8,0,1,2
	db        1,0,246,255,255,255,26,0,9,0,3,0,0,0,6,16
	db        0,0,16,16,0,0,4,0,1,0,51,16,0,0,0,0
	db        0,0,8,0,1,2,1,0,245,255,255,255,26,0,9,0
	db        3,0,0,0,6,16,0,0,16,16,0,0,4,0,1,0
	db        53,16,0,0,0,0,0,0,8,0,1,2,1,0,245,255
	db        255,255,26,0,9,0,3,0,0,0,6,16,0,0,16,16
	db        0,0,4,0,1,0,55,16,0,0,0,0,0,0,8,0
	db        1,2,1,0,244,255,255,255,26,0,9,0,3,0,0,0
	db        6,16,0,0,16,16,0,0,4,0,2,0,57,16,0,0
	db        0,0,0,0,12,0,1,2,2,0,248,255,255,255,48,0
	db        0,0,26,0,9,0,3,0,0,0,6,16,0,0,16,16
	db        0,0,4,0,0,0,59,16,0,0,0,0,0,0,4,0
	db        1,2,0,0,26,0,9,0,3,0,0,0,6,16,0,0
	db        16,16,0,0,4,0,1,0,61,16,0,0,0,0,0,0
	db        8,0,1,2,1,0,243,255,255,255,26,0,9,0,3,4
	db        0,0,6,16,0,0,16,16,0,0,4,0,0,0,63,16
	db        0,0,0,0,0,0,4,0,1,2,0,0,26,0,9,0
	db        3,0,0,0,6,16,0,0,16,16,0,0,4,0,1,0
	db        65,16,0,0,0,0,0,0,8,0,1,2,1,0,48,0
	db        0,0,26,0,9,0,5,16,0,0,6,16,0,0,16,16
	db        0,0,4,0,1,0,67,16,0,0,0,0,0,0,8,0
	db        1,2,1,0,242,255,255,255,26,0,9,0,5,16,0,0
	db        6,16,0,0,16,16,0,0,4,0,1,0,69,16,0,0
	db        0,0,0,0,8,0,1,2,1,0,3,4,0,0,26,0
	db        9,0,5,16,0,0,6,16,0,0,16,16,0,0,0,0
	db        1,0,73,16,0,0,0,0,0,0,8,0,2,0,42,0
	db        72,16,0,0,8,0,1,0,1,0,6,16,0,0,8,0
	db        1,2,1,0,71,16,0,0,26,0,9,0,3,0,0,0
	db        6,16,0,0,16,16,0,0,4,0,0,0,75,16,0,0
	db        0,0,0,0,4,0,1,2,0,0,26,0,9,0,3,0
	db        0,0,6,16,0,0,16,16,0,0,4,0,0,0,77,16
	db        0,0,0,0,0,0,4,0,1,2,0,0,28,0,4,0
	db        16,0,133,16,0,0,34,0,0,0,0,0,0,0,0,0
	db        0,0,0,0,24,0,0,0,1,0,28,0,4,0,1,0
	db        81,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	db        0,0,25,0,0,0,1,0,18,0,3,0,32,0,0,0
	db        17,0,0,0,0,0,0,0,1,0,1,0,20,0,4,2
	db        6,4,80,16,0,0,2,0,26,0,0,0,0,0,0,0
	db        0,0,26,0,9,0,83,16,0,0,78,16,0,0,84,16
	db        0,0,4,0,0,0,85,16,0,0,0,0,0,0,8,0
	db        2,0,10,0,78,16,0,0,8,0,2,0,10,4,78,16
	db        0,0,4,0,1,2,0,0,26,0,9,0,83,16,0,0
	db        78,16,0,0,84,16,0,0,4,0,1,0,89,16,0,0
	db        0,0,0,0,8,0,2,0,42,0,88,16,0,0,8,0
	db        1,0,1,0,78,16,0,0,8,0,1,2,1,0,87,16
	db        0,0,26,0,9,0,91,16,0,0,78,16,0,0,84,16
	db        0,0,4,0,1,0,92,16,0,0,0,0,0,0,8,0
	db        2,0,42,0,78,16,0,0,8,0,1,2,1,0,87,16
	db        0,0,26,0,9,0,91,16,0,0,78,16,0,0,84,16
	db        0,0,4,0,1,0,94,16,0,0,0,0,0,0,8,0
	db        1,2,1,0,87,16,0,0,26,0,9,0,91,16,0,0
	db        78,16,0,0,84,16,0,0,4,0,1,0,96,16,0,0
	db        0,0,0,0,8,0,1,2,1,0,87,16,0,0,26,0
	db        9,0,91,16,0,0,78,16,0,0,84,16,0,0,4,0
	db        1,0,98,16,0,0,0,0,0,0,8,0,1,2,1,0
	db        87,16,0,0,26,0,9,0,78,16,0,0,78,16,0,0
	db        100,16,0,0,4,0,1,0,101,16,0,0,0,0,0,0
	db        8,0,2,0,10,4,88,16,0,0,8,0,1,2,1,0
	db        87,16,0,0,26,0,9,0,78,16,0,0,78,16,0,0
	db        100,16,0,0,4,0,1,0,103,16,0,0,0,0,0,0
	db        8,0,1,2,1,0,87,16,0,0,26,0,9,0,78,16
	db        0,0,78,16,0,0,100,16,0,0,4,0,1,0,105,16
	db        0,0,0,0,0,0,8,0,1,2,1,0,87,16,0,0
	db        26,0,9,0,91,16,0,0,78,16,0,0,84,16,0,0
	db        4,0,1,0,108,16,0,0,0,0,0,0,8,0,1,0
	db        1,0,240,255,255,255,8,0,1,2,1,0,107,16,0,0
	db        26,0,9,0,91,16,0,0,78,16,0,0,84,16,0,0
	db        4,0,1,0,110,16,0,0,0,0,0,0,8,0,1,2
	db        1,0,107,16,0,0,26,0,9,0,48,0,0,0,78,16
	db        0,0,100,16,0,0,4,0,1,0,112,16,0,0,0,0
	db        0,0,8,0,1,2,1,0,107,16,0,0,26,0,9,0
	db        91,16,0,0,78,16,0,0,84,16,0,0,4,0,0,0
	db        114,16,0,0,0,0,0,0,4,0,1,2,0,0,26,0
	db        9,0,48,0,0,0,78,16,0,0,100,16,0,0,4,0
	db        1,0,116,16,0,0,0,0,0,0,8,0,1,2,1,0
	db        87,16,0,0,26,0,9,0,48,0,0,0,78,16,0,0
	db        100,16,0,0,4,0,1,0,118,16,0,0,0,0,0,0
	db        8,0,1,2,1,0,87,16,0,0,22,0,7,2,3,4
	db        82,16,0,0,0,0,0,0,3,4,86,16,0,0,0,0
	db        0,0,12,0,7,2,3,1,90,16,0,0,0,0,0,0
	db        12,0,7,2,3,1,93,16,0,0,0,0,0,0,12,0
	db        7,2,3,1,95,16,0,0,0,0,0,0,12,0,7,2
	db        3,1,97,16,0,0,0,0,0,0,12,0,7,2,3,1
	db        99,16,0,0,0,0,0,0,12,0,7,2,3,1,102,16
	db        0,0,0,0,0,0,12,0,7,2,3,1,104,16,0,0
	db        0,0,0,0,12,0,7,2,3,1,106,16,0,0,0,0
	db        0,0,12,0,7,2,3,1,109,16,0,0,0,0,0,0
	db        12,0,7,2,3,0,111,16,0,0,0,0,0,0,12,0
	db        7,2,3,0,113,16,0,0,0,0,0,0,12,0,7,2
	db        3,1,115,16,0,0,0,0,0,0,12,0,7,2,3,1
	db        117,16,0,0,0,0,0,0,198,0,4,2,0,4,79,16
	db        0,0,3,0,0,0,242,241,9,4,240,255,255,255,27,0
	db        0,0,0,0,0,0,242,241,8,4,2,0,119,16,0,0
	db        28,0,0,0,8,4,1,0,120,16,0,0,29,0,0,0
	db        8,4,1,0,121,16,0,0,30,0,0,0,8,4,1,0
	db        122,16,0,0,31,0,0,0,8,4,1,0,123,16,0,0
	db        32,0,0,0,8,4,1,0,124,16,0,0,33,0,0,0
	db        8,4,1,0,125,16,0,0,34,0,0,0,8,4,1,0
	db        126,16,0,0,35,0,0,0,8,4,1,0,127,16,0,0
	db        36,0,0,0,8,4,1,0,128,16,0,0,37,0,0,0
	db        8,4,1,0,129,16,0,0,38,0,0,0,8,4,1,0
	db        130,16,0,0,39,0,0,0,8,4,1,0,131,16,0,0
	db        40,0,0,0,8,4,1,0,132,16,0,0,41,0,0,0
	db        14,0,52,0,3,0,0,0,4,0,2,0,136,16,0,0
	db        8,0,2,0,10,4,3,0,0,0,12,0,1,2,2,0
	db        135,16,0,0,248,255,255,255,26,0,9,0,138,16,0,0
	db        6,16,0,0,16,16,0,0,0,0,1,0,139,16,0,0
	db        0,0,0,0,8,0,2,0,42,0,6,16,0,0,8,0
	db        1,2,1,0,138,16,0,0,12,0,7,2,1,0,15,16
	db        0,0,0,0,0,0,12,0,7,2,1,0,20,16,0,0
	db        0,0,0,0,12,0,7,2,1,0,22,16,0,0,0,0
	db        0,0,12,0,7,2,1,0,24,16,0,0,0,0,0,0
	db        12,0,7,2,1,0,26,16,0,0,0,0,0,0,12,0
	db        7,2,1,0,28,16,0,0,0,0,0,0,12,0,7,2
	db        1,0,30,16,0,0,0,0,0,0,12,0,7,2,1,0
	db        32,16,0,0,0,0,0,0,12,0,7,2,1,0,34,16
	db        0,0,0,0,0,0,12,0,7,2,1,0,36,16,0,0
	db        0,0,0,0,12,0,7,2,1,0,38,16,0,0,0,0
	db        0,0,12,0,7,2,1,0,40,16,0,0,0,0,0,0
	db        12,0,7,2,1,0,42,16,0,0,0,0,0,0,12,0
	db        7,2,1,0,44,16,0,0,0,0,0,0,12,0,7,2
	db        1,0,46,16,0,0,0,0,0,0,12,0,7,2,1,0
	db        48,16,0,0,0,0,0,0,12,0,7,2,1,0,50,16
	db        0,0,0,0,0,0,12,0,7,2,1,0,52,16,0,0
	db        0,0,0,0,12,0,7,2,1,0,54,16,0,0,0,0
	db        0,0,16,0,7,2,18,0,56,16,0,0,0,0,0,0
	db        240,255,255,255,16,0,7,2,18,0,58,16,0,0,0,0
	db        0,0,140,0,0,0,16,0,7,2,18,0,60,16,0,0
	db        0,0,0,0,144,0,0,0,16,0,7,2,18,0,62,16
	db        0,0,0,0,0,0,220,255,255,255,16,0,7,2,18,0
	db        64,16,0,0,0,0,0,0,188,0,0,0,36,0,7,2
	db        19,4,66,16,0,0,0,0,0,0,44,0,0,0,3,4
	db        68,16,0,0,0,0,0,0,35,20,70,16,0,0,0,0
	db        0,0,16,0,7,2,19,8,74,16,0,0,0,0,0,0
	db        252,255,255,255,16,0,7,2,19,0,76,16,0,0,0,0
	db        0,0,236,255,255,255,12,0,7,2,35,17,137,16,0,0
	db        0,0,0,0,24,0,53,0,241,255,255,255,6,0,0,0
	db        0,0,0,0,0,128,42,0,0,0,43,0,0,0,24,0
	db        53,0,78,16,0,0,4,0,0,0,0,0,0,0,0,128
	db        81,0,0,0,44,0,0,0,24,0,53,0,239,255,255,255
	db        4,0,0,0,0,0,0,0,0,128,79,0,0,0,45,0
	db        0,0,24,0,53,0,48,0,0,0,0,0,0,0,0,0
	db        0,0,0,128,249,1,0,0,249,1,0,0,24,0,53,0
	db        238,255,255,255,6,0,0,0,0,0,0,0,0,128,46,0
	db        0,0,47,0,0,0,24,0,53,0,237,255,255,255,0,0
	db        0,0,0,0,0,0,0,128,100,0,0,0,100,0,0,0
	db        24,0,53,0,48,0,0,0,4,0,0,0,0,0,0,0
	db        0,128,248,1,0,0,48,0,0,0,24,0,53,0,48,0
	db        0,0,6,0,0,0,0,0,0,0,0,128,49,0,0,0
	db        50,0,0,0,24,0,53,0,249,255,255,255,6,0,0,0
	db        0,0,0,0,0,128,51,0,0,0,52,0,0,0,24,0
	db        53,0,11,16,0,0,6,0,0,0,0,0,0,0,0,128
	db        53,0,0,0,54,0,0,0,24,0,53,0,13,16,0,0
	db        4,0,0,0,0,0,0,0,0,128,10,2,0,0,55,0
	db        0,0,24,0,53,0,116,0,0,0,4,0,0,0,0,0
	db        0,0,0,128,16,2,0,0,56,0,0,0,24,0,53,0
	db        116,0,0,0,0,0,0,0,0,0,0,0,0,128,252,1
	db        0,0,252,1,0,0,24,0,53,0,16,0,0,0,6,0
	db        0,0,0,0,0,0,0,128,57,0,0,0,58,0,0,0
	db        24,0,53,0,48,0,0,0,4,0,0,0,0,0,0,0
	db        0,128,138,0,0,0,59,0,0,0,24,0,53,0,48,0
	db        0,0,4,0,0,0,0,0,0,0,0,128,80,0,0,0
	db        60,0,0,0,24,0,53,0,48,0,0,0,4,0,0,0
	db        0,0,0,0,0,128,137,0,0,0,61,0,0,0,24,0
	db        53,0,9,16,0,0,4,0,0,0,0,0,0,0,0,128
	db        8,2,0,0,62,0,0,0,24,0,53,0,116,0,0,0
	db        4,0,0,0,0,0,0,0,0,128,12,2,0,0,63,0
	db        0,0,24,0,53,0,17,0,0,0,6,0,0,0,0,0
	db        0,0,0,128,64,0,0,0,65,0,0,0,24,0,53,0
	db        48,0,0,0,4,0,0,0,0,0,0,0,0,128,116,1
	db        0,0,66,0,0,0,24,0,53,0,48,0,0,0,4,0
	db        0,0,0,0,0,0,0,128,71,0,0,0,67,0,0,0
	db        24,0,53,0,134,16,0,0,0,0,0,0,0,0,0,0
	db        0,128,152,1,0,0,152,1,0,0,24,0,53,0,134,16
	db        0,0,0,0,0,0,0,0,0,0,0,128,160,1,0,0
	db        160,1,0,0,238,3,4,2,10,4,8,16,0,0,0,0
	db        0,4,252,255,255,255,3,0,0,0,242,241,9,4,252,255
	db        255,255,68,0,0,0,0,0,0,0,242,241,6,4,251,255
	db        255,255,1,0,69,0,0,0,0,0,0,0,0,2,242,241
	db        6,4,3,4,0,0,1,0,70,0,0,0,0,0,0,0
	db        4,2,242,241,6,4,9,16,0,0,1,0,71,0,0,0
	db        0,0,0,0,8,2,242,241,6,4,11,16,0,0,1,0
	db        72,0,0,0,0,0,0,0,9,2,242,241,6,4,13,16
	db        0,0,1,0,73,0,0,0,0,0,0,0,10,2,242,241
	db        6,4,116,0,0,0,1,0,74,0,0,0,0,0,0,0
	db        12,2,242,241,6,4,116,0,0,0,1,0,75,0,0,0
	db        0,0,0,0,16,2,242,241,6,4,48,0,0,0,1,0
	db        76,0,0,0,0,0,0,0,20,2,242,241,6,4,48,0
	db        0,0,1,0,77,0,0,0,0,0,0,0,21,2,242,241
	db        8,4,1,0,140,16,0,0,78,0,0,0,8,4,1,0
	db        141,16,0,0,79,0,0,0,8,4,1,0,142,16,0,0
	db        80,0,0,0,8,4,1,0,143,16,0,0,81,0,0,0
	db        8,4,1,0,144,16,0,0,82,0,0,0,8,4,1,0
	db        145,16,0,0,83,0,0,0,8,4,1,0,146,16,0,0
	db        84,0,0,0,8,4,1,0,147,16,0,0,85,0,0,0
	db        8,4,1,0,148,16,0,0,86,0,0,0,8,4,1,0
	db        149,16,0,0,87,0,0,0,8,4,1,0,150,16,0,0
	db        88,0,0,0,8,4,1,0,151,16,0,0,89,0,0,0
	db        8,4,1,0,152,16,0,0,90,0,0,0,8,4,1,0
	db        153,16,0,0,91,0,0,0,8,4,1,0,154,16,0,0
	db        92,0,0,0,8,4,1,0,155,16,0,0,93,0,0,0
	db        8,4,1,0,156,16,0,0,94,0,0,0,8,4,1,0
	db        157,16,0,0,95,0,0,0,8,4,1,0,158,16,0,0
	db        96,0,0,0,8,4,1,0,159,16,0,0,97,0,0,0
	db        8,4,1,0,160,16,0,0,98,0,0,0,8,4,1,0
	db        161,16,0,0,99,0,0,0,8,4,1,0,162,16,0,0
	db        100,0,0,0,8,4,1,0,163,16,0,0,101,0,0,0
	db        8,4,3,0,164,16,0,0,102,0,0,0,8,4,1,0
	db        165,16,0,0,103,0,0,0,8,4,1,0,166,16,0,0
	db        104,0,0,0,6,4,168,16,0,0,3,0,105,0,0,0
	db        0,0,0,0,0,0,242,241,6,4,169,16,0,0,3,0
	db        106,0,0,0,0,0,0,0,0,0,242,241,6,4,170,16
	db        0,0,3,0,107,0,0,0,0,0,0,0,0,0,242,241
	db        6,4,171,16,0,0,3,0,108,0,0,0,0,0,0,0
	db        0,0,242,241,6,4,172,16,0,0,3,0,109,0,0,0
	db        0,0,0,0,0,0,242,241,6,4,173,16,0,0,3,0
	db        110,0,0,0,0,0,0,0,0,0,242,241,6,4,174,16
	db        0,0,3,0,111,0,0,0,0,0,0,0,0,0,242,241
	db        6,4,175,16,0,0,3,0,112,0,0,0,0,0,0,0
	db        0,0,242,241,6,4,176,16,0,0,3,0,113,0,0,0
	db        0,0,0,0,0,0,242,241,6,4,177,16,0,0,3,0
	db        114,0,0,0,0,0,0,0,0,0,242,241,6,4,178,16
	db        0,0,3,0,115,0,0,0,0,0,0,0,0,0,242,241
	db        6,4,179,16,0,0,3,0,116,0,0,0,0,0,0,0
	db        0,0,242,241,6,4,180,16,0,0,3,0,117,0,0,0
	db        0,0,0,0,0,0,242,241,6,4,181,16,0,0,3,0
	db        118,0,0,0,0,0,0,0,0,0,242,241,6,4,182,16
	db        0,0,3,0,119,0,0,0,0,0,0,0,0,0,242,241
	db        6,4,183,16,0,0,3,0,120,0,0,0,0,0,0,0
	db        0,0,242,241,6,4,184,16,0,0,3,0,121,0,0,0
	db        0,0,0,0,0,0,242,241,6,4,185,16,0,0,3,0
	db        122,0,0,0,0,0,0,0,0,0,242,241,6,4,186,16
	db        0,0,3,0,123,0,0,0,0,0,0,0,0,0,242,241
	db        6,4,187,16,0,0,3,0,124,0,0,0,0,0,0,0
	db        0,0,242,241,6,4,188,16,0,0,3,0,125,0,0,0
	db        0,0,0,0,0,0,242,241,6,4,189,16,0,0,3,0
	db        126,0,0,0,0,0,0,0,0,0,242,241,6,4,190,16
	db        0,0,3,0,127,0,0,0,0,0,0,0,0,0,5,4
	db        193,16,0,0,34,0,4,2,6,4,191,16,0,0,3,0
	db        128,0,0,0,0,0,0,0,0,0,242,241,8,4,1,0
	db        167,16,0,0,129,0,0,0,26,0,9,0,3,0,0,0
	db        2,16,0,0,195,16,0,0,4,0,1,0,196,16,0,0
	db        0,0,0,0,8,0,2,0,10,4,2,16,0,0,8,0
	db        1,2,1,0,248,255,255,255,26,0,9,0,3,0,0,0
	db        2,16,0,0,195,16,0,0,4,0,1,0,198,16,0,0
	db        0,0,0,0,8,0,1,2,1,0,248,255,255,255,26,0
	db        9,0,3,0,0,0,2,16,0,0,195,16,0,0,4,0
	db        1,0,200,16,0,0,0,0,0,0,8,0,1,2,1,0
	db        248,255,255,255,26,0,9,0,3,0,0,0,2,16,0,0
	db        195,16,0,0,4,0,0,0,202,16,0,0,0,0,0,0
	db        4,0,1,2,0,0,26,0,9,0,48,0,0,0,2,16
	db        0,0,195,16,0,0,4,0,3,0,204,16,0,0,0,0
	db        0,0,16,0,1,2,3,0,116,0,0,0,116,0,0,0
	db        116,0,0,0,26,0,9,0,3,0,0,0,2,16,0,0
	db        195,16,0,0,4,0,4,0,206,16,0,0,0,0,0,0
	db        20,0,1,2,4,0,17,0,0,0,17,0,0,0,17,0
	db        0,0,17,0,0,0,26,0,9,0,3,0,0,0,2,16
	db        0,0,195,16,0,0,4,0,4,0,208,16,0,0,0,0
	db        0,0,20,0,1,2,4,0,17,0,0,0,17,0,0,0
	db        17,0,0,0,17,0,0,0,26,0,9,0,3,0,0,0
	db        2,16,0,0,195,16,0,0,4,0,4,0,210,16,0,0
	db        0,0,0,0,20,0,1,2,4,0,17,0,0,0,17,0
	db        0,0,17,0,0,0,17,0,0,0,26,0,9,0,3,0
	db        0,0,2,16,0,0,195,16,0,0,4,0,5,0,212,16
	db        0,0,0,0,0,0,24,0,1,2,5,0,17,0,0,0
	db        17,0,0,0,17,0,0,0,17,0,0,0,17,0,0,0
	db        26,0,9,0,3,0,0,0,2,16,0,0,195,16,0,0
	db        4,0,5,0,214,16,0,0,0,0,0,0,24,0,1,2
	db        5,0,17,0,0,0,17,0,0,0,17,0,0,0,17,0
	db        0,0,17,0,0,0,26,0,9,0,3,0,0,0,2,16
	db        0,0,195,16,0,0,4,0,5,0,216,16,0,0,0,0
	db        0,0,24,0,1,2,5,0,17,0,0,0,17,0,0,0
	db        17,0,0,0,17,0,0,0,17,0,0,0,26,0,9,0
	db        3,0,0,0,2,16,0,0,195,16,0,0,4,0,5,0
	db        218,16,0,0,0,0,0,0,24,0,1,2,5,0,17,0
	db        0,0,17,0,0,0,17,0,0,0,17,0,0,0,17,0
	db        0,0,26,0,9,0,1,16,0,0,2,16,0,0,195,16
	db        0,0,4,0,1,0,220,16,0,0,0,0,0,0,8,0
	db        1,2,1,0,242,255,255,255,26,0,9,0,1,16,0,0
	db        2,16,0,0,195,16,0,0,0,0,1,0,224,16,0,0
	db        0,0,0,0,8,0,2,0,42,0,223,16,0,0,8,0
	db        1,0,1,0,2,16,0,0,8,0,1,2,1,0,222,16
	db        0,0,26,0,9,0,226,16,0,0,2,16,0,0,195,16
	db        0,0,0,0,1,0,227,16,0,0,0,0,0,0,8,0
	db        2,0,42,0,2,16,0,0,8,0,1,2,1,0,226,16
	db        0,0,26,0,9,0,3,0,0,0,2,16,0,0,195,16
	db        0,0,4,0,0,0,229,16,0,0,0,0,0,0,4,0
	db        1,2,0,0,12,0,7,2,3,0,194,16,0,0,0,0
	db        0,0,12,0,7,2,3,0,197,16,0,0,0,0,0,0
	db        12,0,7,2,3,0,199,16,0,0,0,0,0,0,12,0
	db        7,2,1,0,201,16,0,0,0,0,0,0,12,0,7,2
	db        1,0,203,16,0,0,0,0,0,0,12,0,7,2,1,0
	db        205,16,0,0,0,0,0,0,12,0,7,2,1,0,207,16
	db        0,0,0,0,0,0,12,0,7,2,1,0,209,16,0,0
	db        0,0,0,0,12,0,7,2,1,0,211,16,0,0,0,0
	db        0,0,12,0,7,2,1,0,213,16,0,0,0,0,0,0
	db        12,0,7,2,1,0,215,16,0,0,0,0,0,0,12,0
	db        7,2,1,0,217,16,0,0,0,0,0,0,26,0,7,2
	db        19,4,219,16,0,0,0,0,0,0,44,0,0,0,35,20
	db        221,16,0,0,0,0,0,0,12,0,7,2,35,17,225,16
	db        0,0,0,0,0,0,16,0,7,2,51,24,228,16,0,0
	db        0,0,0,0,252,255,255,255,150,2,4,2,10,4,4,16
	db        0,0,0,0,0,4,255,255,255,255,3,0,0,0,242,241
	db        6,4,254,255,255,255,3,0,130,0,0,0,0,0,0,0
	db        208,2,242,241,6,4,253,255,255,255,3,0,131,0,0,0
	db        0,0,0,0,212,2,242,241,6,4,5,16,0,0,3,0
	db        132,0,0,0,0,0,0,0,216,2,242,241,6,4,236,255
	db        255,255,3,0,133,0,0,0,0,0,0,0,220,2,242,241
	db        6,4,235,255,255,255,3,0,134,0,0,0,0,0,0,0
	db        224,2,242,241,6,4,234,255,255,255,3,0,135,0,0,0
	db        0,0,0,0,228,2,242,241,6,4,234,255,255,255,3,0
	db        136,0,0,0,0,0,0,0,232,2,242,241,6,4,235,255
	db        255,255,3,0,137,0,0,0,0,0,0,0,236,2,242,241
	db        6,4,234,255,255,255,3,0,138,0,0,0,0,0,0,0
	db        240,2,242,241,6,4,234,255,255,255,3,0,139,0,0,0
	db        0,0,0,0,244,2,242,241,6,4,233,255,255,255,3,0
	db        140,0,0,0,0,0,0,0,248,2,242,241,6,4,233,255
	db        255,255,3,0,141,0,0,0,0,0,0,0,252,2,242,241
	db        6,4,233,255,255,255,3,0,142,0,0,0,0,0,0,0
	db        0,3,242,241,6,4,233,255,255,255,3,0,143,0,0,0
	db        0,0,0,0,4,3,242,241,6,4,232,255,255,255,3,0
	db        144,0,0,0,0,0,0,0,8,3,242,241,6,4,231,255
	db        255,255,3,0,145,0,0,0,0,0,0,0,12,3,242,241
	db        6,4,231,255,255,255,3,0,146,0,0,0,0,0,0,0
	db        16,3,242,241,6,4,235,255,255,255,3,0,147,0,0,0
	db        0,0,0,0,20,3,242,241,6,4,234,255,255,255,3,0
	db        148,0,0,0,0,0,0,0,24,3,242,241,6,4,233,255
	db        255,255,3,0,149,0,0,0,0,0,0,0,28,3,242,241
	db        6,4,235,255,255,255,3,0,150,0,0,0,0,0,0,0
	db        32,3,242,241,6,4,234,255,255,255,3,0,151,0,0,0
	db        0,0,0,0,36,3,242,241,6,4,5,16,0,0,3,0
	db        152,0,0,0,0,0,0,0,40,3,242,241,8,4,1,0
	db        230,16,0,0,153,0,0,0,8,4,1,0,231,16,0,0
	db        154,0,0,0,8,4,1,0,232,16,0,0,155,0,0,0
	db        8,4,1,0,233,16,0,0,156,0,0,0,8,4,1,0
	db        234,16,0,0,157,0,0,0,8,4,1,0,235,16,0,0
	db        158,0,0,0,8,4,1,0,236,16,0,0,159,0,0,0
	db        8,4,1,0,237,16,0,0,160,0,0,0,8,4,1,0
	db        238,16,0,0,161,0,0,0,8,4,1,0,239,16,0,0
	db        162,0,0,0,8,4,1,0,240,16,0,0,163,0,0,0
	db        8,4,1,0,241,16,0,0,164,0,0,0,8,4,2,0
	db        242,16,0,0,165,0,0,0,8,4,1,0,243,16,0,0
	db        166,0,0,0,8,4,1,0,244,16,0,0,167,0,0,0
	db        8,0,1,2,1,0,242,255,255,255,26,0,9,0,3,0
	db        0,0,2,16,0,0,195,16,0,0,4,0,1,0,248,16
	db        0,0,0,0,0,0,8,0,1,2,1,0,248,255,255,255
	db        26,0,9,0,3,0,0,0,2,16,0,0,195,16,0,0
	db        4,0,1,0,250,16,0,0,0,0,0,0,8,0,1,2
	db        1,0,248,255,255,255,26,0,9,0,3,0,0,0,2,16
	db        0,0,195,16,0,0,4,0,1,0,252,16,0,0,0,0
	db        0,0,8,0,1,2,1,0,248,255,255,255,26,0,9,0
	db        3,0,0,0,2,16,0,0,195,16,0,0,4,0,0,0
	db        254,16,0,0,0,0,0,0,4,0,1,2,0,0,26,0
	db        9,0,48,0,0,0,2,16,0,0,195,16,0,0,4,0
	db        3,0,0,17,0,0,0,0,0,0,16,0,1,2,3,0
	db        116,0,0,0,116,0,0,0,116,0,0,0,26,0,9,0
	db        3,0,0,0,2,16,0,0,195,16,0,0,4,0,4,0
	db        2,17,0,0,0,0,0,0,20,0,1,2,4,0,17,0
	db        0,0,17,0,0,0,17,0,0,0,17,0,0,0,26,0
	db        9,0,3,0,0,0,2,16,0,0,195,16,0,0,4,0
	db        4,0,4,17,0,0,0,0,0,0,20,0,1,2,4,0
	db        17,0,0,0,17,0,0,0,17,0,0,0,17,0,0,0
	db        26,0,9,0,3,0,0,0,2,16,0,0,195,16,0,0
	db        4,0,4,0,6,17,0,0,0,0,0,0,20,0,1,2
	db        4,0,17,0,0,0,17,0,0,0,17,0,0,0,17,0
	db        0,0,26,0,9,0,3,0,0,0,2,16,0,0,195,16
	db        0,0,4,0,5,0,8,17,0,0,0,0,0,0,24,0
	db        1,2,5,0,17,0,0,0,17,0,0,0,17,0,0,0
	db        17,0,0,0,17,0,0,0,26,0,9,0,3,0,0,0
	db        2,16,0,0,195,16,0,0,4,0,5,0,10,17,0,0
	db        0,0,0,0,24,0,1,2,5,0,17,0,0,0,17,0
	db        0,0,17,0,0,0,17,0,0,0,17,0,0,0,26,0
	db        9,0,3,0,0,0,2,16,0,0,195,16,0,0,4,0
	db        5,0,12,17,0,0,0,0,0,0,24,0,1,2,5,0
	db        17,0,0,0,17,0,0,0,17,0,0,0,17,0,0,0
	db        17,0,0,0,26,0,9,0,229,255,255,255,255,255,255,255
	db        14,17,0,0,4,0,1,0,15,17,0,0,0,0,0,0
	db        8,0,2,0,10,4,255,255,255,255,8,0,1,2,1,0
	db        242,255,255,255,26,0,9,0,230,255,255,255,228,255,255,255
	db        17,17,0,0,0,0,4,0,18,17,0,0,0,0,0,0
	db        8,0,2,0,10,4,228,255,255,255,20,0,1,2,4,0
	db        116,0,0,0,116,0,0,0,116,0,0,0,116,0,0,0
	db        26,0,9,0,227,255,255,255,238,255,255,255,20,17,0,0
	db        4,0,0,0,21,17,0,0,0,0,0,0,8,0,2,0
	db        10,4,238,255,255,255,4,0,1,2,0,0,26,0,9,0
	db        116,0,0,0,238,255,255,255,23,17,0,0,4,0,0,0
	db        25,17,0,0,0,0,0,0,8,0,2,0,10,4,24,17
	db        0,0,8,0,1,0,1,0,238,255,255,255,4,0,1,2
	db        0,0,26,0,9,0,226,255,255,255,238,255,255,255,23,17
	db        0,0,0,0,0,0,27,17,0,0,0,0,0,0,4,0
	db        1,2,0,0,26,0,9,0,3,0,0,0,2,16,0,0
	db        195,16,0,0,4,0,0,0,29,17,0,0,0,0,0,0
	db        4,0,1,2,0,0,26,0,9,0,3,0,0,0,225,255
	db        255,255,31,17,0,0,4,0,3,0,32,17,0,0,0,0
	db        0,0,8,0,2,0,10,4,225,255,255,255,16,0,1,2
	db        3,0,48,0,0,0,24,17,0,0,24,17,0,0,26,0
	db        9,0,229,255,255,255,255,255,255,255,14,17,0,0,4,0
	db        2,0,34,17,0,0,0,0,0,0,12,0,1,2,2,0
	db        242,255,255,255,116,0,0,0,26,0,9,0,3,0,0,0
	db        255,255,255,255,14,17,0,0,4,0,0,0,36,17,0,0
	db        0,0,0,0,4,0,1,2,0,0,26,0,9,0,3,0
	db        0,0,38,17,0,0,41,17,0,0,4,0,0,0,79,17
	db        0,0,0,0,0,0,28,0,4,0,10,0,78,17,0,0
	db        34,1,0,0,0,0,0,0,0,0,0,0,0,0,8,1
	db        0,0,4,0,26,0,9,0,40,17,0,0,38,17,0,0
	db        41,17,0,0,4,0,0,0,42,17,0,0,0,0,0,0
	db        8,0,2,0,10,0,38,17,0,0,8,0,2,0,10,4
	db        38,17,0,0,4,0,1,2,0,0,26,0,9,0,40,17
	db        0,0,38,17,0,0,41,17,0,0,4,0,1,0,46,17
	db        0,0,0,0,0,0,8,0,2,0,42,0,45,17,0,0
	db        8,0,1,0,1,0,38,17,0,0,8,0,1,2,1,0
	db        44,17,0,0,26,0,9,0,40,17,0,0,38,17,0,0
	db        41,17,0,0,4,0,1,0,48,17,0,0,0,0,0,0
	db        8,0,1,2,1,0,224,255,255,255,26,0,9,0,3,0
	db        0,0,38,17,0,0,41,17,0,0,4,0,0,0,50,17
	db        0,0,0,0,0,0,4,0,1,2,0,0,26,0,9,0
	db        52,17,0,0,38,17,0,0,41,17,0,0,4,0,1,0
	db        53,17,0,0,0,0,0,0,8,0,2,0,42,0,38,17
	db        0,0,8,0,1,2,1,0,52,17,0,0,26,0,9,0
	db        52,17,0,0,38,17,0,0,41,17,0,0,4,0,1,0
	db        55,17,0,0,0,0,0,0,8,0,1,2,1,0,224,255
	db        255,255,26,0,9,0,224,255,255,255,38,17,0,0,57,17
	db        0,0,4,0,0,0,58,17,0,0,0,0,0,0,8,0
	db        2,0,10,4,45,17,0,0,4,0,1,2,0,0,26,0
	db        9,0,48,0,0,0,38,17,0,0,57,17,0,0,0,0
	db        0,0,60,17,0,0,0,0,0,0,4,0,1,2,0,0
	db        26,0,9,0,224,255,255,255,38,17,0,0,57,17,0,0
	db        4,0,0,0,62,17,0,0,0,0,0,0,4,0,1,2
	db        0,0,26,0,9,0,223,255,255,255,38,17,0,0,41,17
	db        0,0,4,0,0,0,64,17,0,0,0,0,0,0,4,0
	db        1,2,0,0,26,0,9,0,3,0,0,0,38,17,0,0
	db        41,17,0,0,0,0,0,0,66,17,0,0,0,0,0,0
	db        4,0,1,2,0,0,26,0,9,0,222,255,255,255,38,17
	db        0,0,41,17,0,0,4,0,0,0,68,17,0,0,0,0
	db        0,0,4,0,1,2,0,0,42,0,7,2,3,4,39,17
	db        0,0,0,0,0,0,3,4,0,0,0,0,0,0,0,0
	db        3,4,43,17,0,0,0,0,0,0,3,4,47,17,0,0
	db        0,0,0,0,12,0,7,2,3,8,49,17,0,0,0,0
	db        0,0,22,0,7,2,3,1,51,17,0,0,0,0,0,0
	db        3,1,54,17,0,0,0,0,0,0,12,0,7,2,3,1
	db        56,17,0,0,0,0,0,0,12,0,7,2,3,1,59,17
	db        0,0,0,0,0,0,12,0,7,2,3,2,61,17,0,0
	db        0,0,0,0,12,0,7,2,3,1,63,17,0,0,0,0
	db        0,0,12,0,7,2,3,0,65,17,0,0,0,0,0,0
	db        12,0,7,2,3,1,67,17,0,0,0,0,0,0,130,0
	db        4,2,6,4,224,255,255,255,1,0,9,1,0,0,0,0
	db        0,0,0,0,242,241,8,4,4,0,69,17,0,0,10,1
	db        0,0,8,4,1,0,70,17,0,0,11,1,0,0,8,4
	db        2,0,71,17,0,0,12,1,0,0,8,4,1,0,72,17
	db        0,0,13,1,0,0,8,4,1,0,73,17,0,0,14,1
	db        0,0,8,4,1,0,74,17,0,0,15,1,0,0,8,4
	db        1,0,75,17,0,0,16,1,0,0,8,4,1,0,76,17
	db        0,0,17,1,0,0,8,4,1,0,77,17,0,0,18,1
	db        0,0,4,0,1,2,0,0,26,0,9,0,3,0,0,0
	db        81,17,0,0,84,17,0,0,4,0,0,0,122,17,0,0
	db        0,0,0,0,28,0,4,0,10,0,121,17,0,0,34,1
	db        0,0,0,0,0,0,0,0,0,0,0,0,21,1,0,0
	db        4,0,26,0,9,0,83,17,0,0,81,17,0,0,84,17
	db        0,0,4,0,0,0,85,17,0,0,0,0,0,0,8,0
	db        2,0,10,0,81,17,0,0,8,0,2,0,10,4,81,17
	db        0,0,4,0,1,2,0,0,26,0,9,0,83,17,0,0
	db        81,17,0,0,84,17,0,0,4,0,1,0,89,17,0,0
	db        0,0,0,0,8,0,2,0,42,0,88,17,0,0,8,0
	db        1,0,1,0,81,17,0,0,8,0,1,2,1,0,87,17
	db        0,0,26,0,9,0,83,17,0,0,81,17,0,0,84,17
	db        0,0,4,0,1,0,91,17,0,0,0,0,0,0,8,0
	db        1,2,1,0,221,255,255,255,26,0,9,0,3,0,0,0
	db        81,17,0,0,84,17,0,0,4,0,0,0,93,17,0,0
	db        0,0,0,0,4,0,1,2,0,0,26,0,9,0,95,17
	db        0,0,81,17,0,0,84,17,0,0,4,0,1,0,96,17
	db        0,0,0,0,0,0,8,0,2,0,42,0,81,17,0,0
	db        8,0,1,2,1,0,95,17,0,0,26,0,9,0,95,17
	db        0,0,81,17,0,0,84,17,0,0,4,0,1,0,98,17
	db        0,0,0,0,0,0,8,0,1,2,1,0,221,255,255,255
	db        26,0,9,0,221,255,255,255,81,17,0,0,100,17,0,0
	db        4,0,0,0,101,17,0,0,0,0,0,0,8,0,2,0
	db        10,4,88,17,0,0,4,0,1,2,0,0,26,0,9,0
	db        48,0,0,0,81,17,0,0,100,17,0,0,0,0,0,0
	db        103,17,0,0,0,0,0,0,4,0,1,2,0,0,26,0
	db        9,0,221,255,255,255,81,17,0,0,100,17,0,0,4,0
	db        0,0,105,17,0,0,0,0,0,0,4,0,1,2,0,0
	db        26,0,9,0,220,255,255,255,81,17,0,0,84,17,0,0
	db        4,0,0,0,107,17,0,0,0,0,0,0,4,0,1,2
	db        0,0,26,0,9,0,3,0,0,0,81,17,0,0,84,17
	db        0,0,0,0,0,0,109,17,0,0,0,0,0,0,4,0
	db        1,2,0,0,26,0,9,0,219,255,255,255,81,17,0,0
	db        84,17,0,0,4,0,0,0,111,17,0,0,0,0,0,0
	db        4,0,1,2,0,0,42,0,7,2,3,4,82,17,0,0
	db        0,0,0,0,3,4,0,0,0,0,0,0,0,0,3,4
	db        86,17,0,0,0,0,0,0,3,4,90,17,0,0,0,0
	db        0,0,12,0,7,2,3,8,92,17,0,0,0,0,0,0
	db        22,0,7,2,3,1,94,17,0,0,0,0,0,0,3,1
	db        97,17,0,0,0,0,0,0,12,0,7,2,3,1,99,17
	db        0,0,0,0,0,0,12,0,7,2,3,1,102,17,0,0
	db        0,0,0,0,12,0,7,2,3,2,104,17,0,0,0,0
	db        0,0,12,0,7,2,3,1,106,17,0,0,0,0,0,0
	db        12,0,7,2,3,0,108,17,0,0,0,0,0,0,12,0
	db        7,2,3,1,110,17,0,0,0,0,0,0,130,0,4,2
	db        6,4,221,255,255,255,1,0,22,1,0,0,0,0,0,0
	db        0,0,242,241,8,4,4,0,112,17,0,0,23,1,0,0
	db        8,4,1,0,113,17,0,0,24,1,0,0,8,4,2,0
	db        114,17,0,0,25,1,0,0,8,4,1,0,115,17,0,0
	db        26,1,0,0,8,4,1,0,116,17,0,0,27,1,0,0
	db        8,4,1,0,117,17,0,0,28,1,0,0,8,4,1,0
	db        118,17,0,0,29,1,0,0,8,4,1,0,119,17,0,0
	db        30,1,0,0,8,4,1,0,120,17,0,0,31,1,0,0
	db        4,0,1,2,0,0,26,0,9,0,3,0,0,0,124,17
	db        0,0,127,17,0,0,4,0,0,0,165,17,0,0,0,0
	db        0,0,28,0,4,0,10,0,164,17,0,0,34,1,0,0
	db        0,0,0,0,0,0,0,0,0,0,34,1,0,0,4,0
	db        26,0,9,0,126,17,0,0,124,17,0,0,127,17,0,0
	db        4,0,0,0,128,17,0,0,0,0,0,0,8,0,2,0
	db        10,0,124,17,0,0,8,0,2,0,10,4,124,17,0,0
	db        4,0,1,2,0,0,26,0,9,0,126,17,0,0,124,17
	db        0,0,127,17,0,0,4,0,1,0,132,17,0,0,0,0
	db        0,0,8,0,2,0,42,0,131,17,0,0,8,0,1,0
	db        1,0,124,17,0,0,8,0,1,2,1,0,130,17,0,0
	db        26,0,9,0,126,17,0,0,124,17,0,0,127,17,0,0
	db        4,0,1,0,134,17,0,0,0,0,0,0,8,0,1,2
	db        1,0,218,255,255,255,26,0,9,0,3,0,0,0,124,17
	db        0,0,127,17,0,0,4,0,0,0,136,17,0,0,0,0
	db        0,0,4,0,1,2,0,0,26,0,9,0,138,17,0,0
	db        124,17,0,0,127,17,0,0,4,0,1,0,139,17,0,0
	db        0,0,0,0,8,0,2,0,42,0,124,17,0,0,8,0
	db        1,2,1,0,138,17,0,0,26,0,9,0,138,17,0,0
	db        124,17,0,0,127,17,0,0,4,0,1,0,141,17,0,0
	db        0,0,0,0,8,0,1,2,1,0,218,255,255,255,26,0
	db        9,0,218,255,255,255,124,17,0,0,143,17,0,0,4,0
	db        0,0,144,17,0,0,0,0,0,0,8,0,2,0,10,4
	db        131,17,0,0,4,0,1,2,0,0,26,0,9,0,48,0
	db        0,0,124,17,0,0,143,17,0,0,0,0,0,0,146,17
	db        0,0,0,0,0,0,4,0,1,2,0,0,26,0,9,0
	db        218,255,255,255,124,17,0,0,143,17,0,0,4,0,0,0
	db        148,17,0,0,0,0,0,0,4,0,1,2,0,0,26,0
	db        9,0,217,255,255,255,124,17,0,0,127,17,0,0,4,0
	db        0,0,150,17,0,0,0,0,0,0,4,0,1,2,0,0
	db        26,0,9,0,3,0,0,0,124,17,0,0,127,17,0,0
	db        0,0,0,0,152,17,0,0,0,0,0,0,4,0,1,2
	db        0,0,26,0,9,0,216,255,255,255,124,17,0,0,127,17
	db        0,0,4,0,0,0,154,17,0,0,0,0,0,0,4,0
	db        1,2,0,0,42,0,7,2,3,4,125,17,0,0,0,0
	db        0,0,3,4,0,0,0,0,0,0,0,0,3,4,129,17
	db        0,0,0,0,0,0,3,4,133,17,0,0,0,0,0,0
	db        12,0,7,2,3,8,135,17,0,0,0,0,0,0,22,0
	db        7,2,3,1,137,17,0,0,0,0,0,0,3,1,140,17
	db        0,0,0,0,0,0,12,0,7,2,3,1,142,17,0,0
	db        0,0,0,0,12,0,7,2,3,1,145,17,0,0,0,0
	db        0,0,12,0,7,2,3,2,147,17,0,0,0,0,0,0
	db        12,0,7,2,3,1,149,17,0,0,0,0,0,0,12,0
	db        7,2,3,0,151,17,0,0,0,0,0,0,12,0,7,2
	db        3,1,153,17,0,0,0,0,0,0,130,0,4,2,6,4
	db        218,255,255,255,1,0,35,1,0,0,0,0,0,0,0,0
	db        242,241,8,4,4,0,155,17,0,0,36,1,0,0,8,4
	db        1,0,156,17,0,0,37,1,0,0,8,4,2,0,157,17
	db        0,0,38,1,0,0,8,4,1,0,158,17,0,0,39,1
	db        0,0,8,4,1,0,159,17,0,0,40,1,0,0,8,4
	db        1,0,160,17,0,0,41,1,0,0,8,4,1,0,161,17
	db        0,0,42,1,0,0,8,4,1,0,162,17,0,0,43,1
	db        0,0,8,4,1,0,163,17,0,0,44,1,0,0,4,0
	db        1,2,0,0,8,0,1,0,1,0,16,0,0,0,8,0
	db        1,0,1,0,33,0,0,0,8,0,1,0,1,0,215,255
	db        255,255,14,0,8,0,251,255,255,255,4,0,1,0,171,17
	db        0,0,8,0,2,0,10,4,214,255,255,255,8,0,1,2
	db        1,0,170,17,0,0,14,0,8,0,3,0,0,0,4,0
	db        5,0,174,17,0,0,8,0,2,0,10,4,213,255,255,255
	db        24,0,1,2,5,0,173,17,0,0,116,0,0,0,116,0
	db        0,0,215,255,255,255,212,255,255,255,14,0,8,0,3,0
	db        0,0,4,0,2,0,177,17,0,0,8,0,2,0,10,4
	db        211,255,255,255,12,0,1,2,2,0,176,17,0,0,24,17
	db        0,0,14,0,8,0,227,255,255,255,4,0,2,0,181,17
	db        0,0,8,0,2,0,10,0,180,17,0,0,8,0,1,0
	db        1,0,112,0,0,0,12,0,1,2,2,0,20,17,0,0
	db        179,17,0,0,14,0,8,0,3,0,0,0,4,0,2,0
	db        183,17,0,0,12,0,1,2,2,0,20,17,0,0,116,0
	db        0,0,14,0,8,0,3,0,0,0,4,0,2,0,186,17
	db        0,0,8,0,2,0,10,4,210,255,255,255,12,0,1,2
	db        2,0,185,17,0,0,116,0,0,0,8,0,2,0,10,2
	db        3,0,0,0,14,0,8,0,3,0,0,0,4,0,1,0
	db        189,17,0,0,8,0,1,2,1,0,3,4,0,0,14,0
	db        8,0,116,0,0,0,2,0,0,0,191,17,0,0,4,0
	db        1,2,0,0,14,0,8,0,3,4,0,0,0,0,1,0
	db        193,17,0,0,8,0,1,2,1,0,117,0,0,0,14,0
	db        8,0,3,0,0,0,4,0,2,0,195,17,0,0,12,0
	db        1,2,2,0,173,17,0,0,209,255,255,255,14,0,8,0
	db        3,0,0,0,0,0,1,0,197,17,0,0,8,0,1,2
	db        1,0,3,4,0,0,14,0,8,0,238,255,255,255,4,0
	db        1,0,199,17,0,0,8,0,1,2,1,0,176,17,0,0
	db        14,0,8,0,116,0,0,0,4,0,1,0,201,17,0,0
	db        8,0,1,2,1,0,185,17,0,0,8,0,1,0,1,0
	db        203,17,0,0,14,0,8,0,116,0,0,0,4,0,1,0
	db        204,17,0,0,8,0,1,2,1,0,23,17,0,0,14,0
	db        8,0,3,0,0,0,4,0,2,0,206,17,0,0,12,0
	db        1,2,2,0,176,17,0,0,48,0,0,0,14,0,8,0
	db        3,0,0,0,4,0,4,0,208,17,0,0,20,0,1,2
	db        4,0,173,17,0,0,116,0,0,0,116,0,0,0,215,255
	db        255,255,14,0,8,0,3,0,0,0,4,0,4,0,210,17
	db        0,0,20,0,1,2,4,0,173,17,0,0,116,0,0,0
	db        116,0,0,0,24,17,0,0,14,0,8,0,208,255,255,255
	db        4,0,3,0,213,17,0,0,8,0,2,0,10,4,207,255
	db        255,255,16,0,1,2,3,0,212,17,0,0,16,0,0,0
	db        242,255,255,255,14,0,8,0,18,0,0,0,4,0,3,0
	db        215,17,0,0,16,0,1,2,3,0,31,17,0,0,248,255
	db        255,255,3,4,0,0,14,0,8,0,3,0,0,0,4,0
	db        1,0,217,17,0,0,8,0,1,2,1,0,212,17,0,0
	db        14,0,8,0,3,0,0,0,4,0,1,0,219,17,0,0
	db        8,0,1,2,1,0,212,17,0,0,14,0,8,0,3,0
	db        0,0,4,0,2,0,222,17,0,0,8,0,2,0,10,4
	db        206,255,255,255,12,0,1,2,2,0,221,17,0,0,3,4
	db        0,0,14,0,8,0,3,0,0,0,4,0,2,0,224,17
	db        0,0,12,0,1,2,2,0,212,17,0,0,3,4,0,0
	db        14,0,8,0,248,255,255,255,4,0,2,0,226,17,0,0
	db        12,0,1,2,2,0,221,17,0,0,205,255,255,255,14,0
	db        8,0,3,0,0,0,4,0,1,0,228,17,0,0,8,0
	db        1,2,1,0,221,17,0,0,14,0,8,0,3,0,0,0
	db        4,0,2,0,231,17,0,0,8,0,2,0,10,4,204,255
	db        255,255,12,0,1,2,2,0,230,17,0,0,203,255,255,255
	db        14,0,8,0,3,0,0,0,4,0,2,0,233,17,0,0
	db        12,0,1,2,2,0,212,17,0,0,202,255,255,255,14,0
	db        8,0,3,0,0,0,4,0,2,0,236,17,0,0,8,0
	db        2,0,10,4,201,255,255,255,12,0,1,2,2,0,235,17
	db        0,0,203,255,255,255,14,0,8,0,3,0,0,0,4,0
	db        1,0,238,17,0,0,8,0,1,2,1,0,212,17,0,0
	db        14,0,8,0,3,0,0,0,4,0,3,0,240,17,0,0
	db        16,0,1,2,3,0,212,17,0,0,242,255,255,255,200,255
	db        255,255,14,0,8,0,3,0,0,0,4,0,2,0,242,17
	db        0,0,12,0,1,2,2,0,212,17,0,0,199,255,255,255
	db        14,0,8,0,3,0,0,0,4,0,2,0,244,17,0,0
	db        12,0,1,2,2,0,176,17,0,0,24,17,0,0,14,0
	db        8,0,3,0,0,0,4,0,4,0,246,17,0,0,20,0
	db        1,2,4,0,212,17,0,0,242,255,255,255,24,17,0,0
	db        24,17,0,0,14,0,8,0,3,0,0,0,4,0,2,0
	db        248,17,0,0,12,0,1,2,2,0,31,17,0,0,198,255
	db        255,255,14,0,8,0,18,0,0,0,7,0,3,0,250,17
	db        0,0,16,0,1,2,3,0,212,17,0,0,197,255,255,255
	db        3,4,0,0,14,0,8,0,48,0,0,0,4,0,3,0
	db        253,17,0,0,8,0,2,0,42,0,116,0,0,0,16,0
	db        1,2,3,0,230,17,0,0,252,17,0,0,252,17,0,0
	db        14,0,8,0,48,0,0,0,4,0,3,0,255,17,0,0
	db        16,0,1,2,3,0,230,17,0,0,252,17,0,0,252,17
	db        0,0,14,0,8,0,3,0,0,0,4,0,5,0,1,18
	db        0,0,24,0,1,2,5,0,230,17,0,0,252,17,0,0
	db        252,17,0,0,252,17,0,0,252,17,0,0,14,0,8,0
	db        196,255,255,255,4,0,1,0,3,18,0,0,8,0,1,2
	db        1,0,230,17,0,0,14,0,8,0,228,255,255,255,4,0
	db        1,0,5,18,0,0,8,0,1,2,1,0,212,17,0,0
	db        14,0,8,0,3,4,0,0,4,0,2,0,8,18,0,0
	db        8,0,2,0,42,0,3,4,0,0,12,0,1,2,2,0
	db        230,17,0,0,7,18,0,0,14,0,8,0,195,255,255,255
	db        4,0,1,0,10,18,0,0,8,0,1,2,1,0,176,17
	db        0,0,14,0,8,0,48,0,0,0,4,0,1,0,12,18
	db        0,0,8,0,1,2,1,0,176,17,0,0,14,0,8,0
	db        48,0,0,0,4,0,1,0,14,18,0,0,8,0,1,2
	db        1,0,212,17,0,0,14,0,8,0,205,255,255,255,4,0
	db        1,0,16,18,0,0,8,0,1,2,1,0,176,17,0,0
	db        14,0,8,0,3,0,0,0,4,0,2,0,18,18,0,0
	db        12,0,1,2,2,0,176,17,0,0,194,255,255,255,14,0
	db        8,0,3,0,0,0,4,0,2,0,20,18,0,0,12,0
	db        1,2,2,0,176,17,0,0,48,0,0,0,14,0,8,0
	db        3,0,0,0,4,0,2,0,22,18,0,0,12,0,1,2
	db        2,0,212,17,0,0,193,255,255,255,14,0,8,0,3,0
	db        0,0,4,0,2,0,24,18,0,0,12,0,1,2,2,0
	db        212,17,0,0,48,0,0,0,14,0,8,0,3,0,0,0
	db        4,0,2,0,26,18,0,0,12,0,1,2,2,0,176,17
	db        0,0,239,255,255,255,14,0,8,0,3,0,0,0,4,0
	db        2,0,28,18,0,0,12,0,1,2,2,0,212,17,0,0
	db        245,255,255,255,14,0,8,0,3,0,0,0,4,0,1,0
	db        30,18,0,0,8,0,1,2,1,0,176,17,0,0,14,0
	db        8,0,3,0,0,0,4,0,1,0,32,18,0,0,8,0
	db        1,2,1,0,230,17,0,0,14,0,8,0,3,0,0,0
	db        4,0,1,0,34,18,0,0,8,0,1,2,1,0,230,17
	db        0,0,14,0,8,0,3,0,0,0,4,0,5,0,36,18
	db        0,0,24,0,1,2,5,0,230,17,0,0,116,0,0,0
	db        116,0,0,0,116,0,0,0,116,0,0,0,14,0,8,0
	db        3,0,0,0,4,0,1,0,38,18,0,0,8,0,1,2
	db        1,0,230,17,0,0,14,0,8,0,3,0,0,0,4,0
	db        2,0,41,18,0,0,8,0,2,0,10,4,192,255,255,255
	db        12,0,1,2,2,0,40,18,0,0,209,255,255,255,14,0
	db        8,0,3,0,0,0,4,0,3,0,43,18,0,0,16,0
	db        1,2,3,0,212,17,0,0,191,255,255,255,209,255,255,255
	db        14,0,8,0,3,0,0,0,4,0,1,0,45,18,0,0
	db        8,0,1,2,1,0,230,17,0,0,14,0,8,0,3,0
	db        0,0,4,0,2,0,47,18,0,0,12,0,1,2,2,0
	db        212,17,0,0,243,255,255,255,14,0,8,0,3,0,0,0
	db        4,0,2,0,49,18,0,0,12,0,1,2,2,0,212,17
	db        0,0,243,255,255,255,14,0,8,0,3,0,0,0,4,0
	db        1,0,51,18,0,0,8,0,1,2,1,0,212,17,0,0
	db        14,0,8,0,3,0,0,0,4,0,1,0,53,18,0,0
	db        8,0,1,2,1,0,212,17,0,0,14,0,8,0,3,0
	db        0,0,4,0,1,0,55,18,0,0,8,0,1,2,1,0
	db        230,17,0,0,14,0,8,0,228,255,255,255,4,0,1,0
	db        57,18,0,0,8,0,1,2,1,0,230,17,0,0,14,0
	db        8,0,3,0,0,0,4,0,2,0,59,18,0,0,12,0
	db        1,2,2,0,212,17,0,0,3,4,0,0,14,0,8,0
	db        3,0,0,0,4,0,2,0,61,18,0,0,12,0,1,2
	db        2,0,230,17,0,0,191,255,255,255,14,0,8,0,3,0
	db        0,0,4,0,1,0,63,18,0,0,8,0,1,2,1,0
	db        212,17,0,0,14,0,8,0,48,0,0,0,4,0,1,0
	db        65,18,0,0,8,0,1,2,1,0,40,18,0,0,14,0
	db        8,0,3,0,0,0,4,0,2,0,67,18,0,0,12,0
	db        1,2,2,0,40,18,0,0,191,255,255,255,14,0,8,0
	db        3,0,0,0,4,0,2,0,69,18,0,0,12,0,1,2
	db        2,0,212,17,0,0,190,255,255,255,14,0,8,0,3,0
	db        0,0,4,0,1,0,71,18,0,0,8,0,1,2,1,0
	db        212,17,0,0,14,0,8,0,3,0,0,0,4,0,1,0
	db        73,18,0,0,8,0,1,2,1,0,212,17,0,0,14,0
	db        8,0,3,0,0,0,4,0,1,0,75,18,0,0,8,0
	db        1,2,1,0,212,17,0,0,14,0,8,0,48,0,0,0
	db        4,0,1,0,77,18,0,0,8,0,1,2,1,0,212,17
	db        0,0,14,0,8,0,48,0,0,0,4,0,2,0,79,18
	db        0,0,12,0,1,2,2,0,212,17,0,0,193,255,255,255
	db        14,0,8,0,116,0,0,0,4,0,1,0,81,18,0,0
	db        8,0,1,2,1,0,212,17,0,0,14,0,8,0,48,0
	db        0,0,4,0,3,0,83,18,0,0,16,0,1,2,3,0
	db        212,17,0,0,191,255,255,255,245,255,255,255,14,0,8,0
	db        227,255,255,255,4,0,2,0,85,18,0,0,12,0,1,2
	db        2,0,20,17,0,0,189,255,255,255,14,0,8,0,3,0
	db        0,0,4,0,4,0,87,18,0,0,20,0,1,2,4,0
	db        205,255,255,255,48,0,0,0,24,17,0,0,24,17,0,0
	db        14,0,8,0,208,255,255,255,4,0,4,0,89,18,0,0
	db        20,0,1,2,4,0,212,17,0,0,16,0,0,0,242,255
	db        255,255,116,0,0,0,14,0,8,0,3,0,0,0,4,0
	db        2,0,91,18,0,0,12,0,1,2,2,0,212,17,0,0
	db        16,0,0,0,14,0,8,0,3,0,0,0,4,0,2,0
	db        93,18,0,0,12,0,1,2,2,0,40,18,0,0,16,0
	db        0,0,14,0,8,0,3,0,0,0,4,0,2,0,95,18
	db        0,0,12,0,1,2,2,0,230,17,0,0,16,0,0,0
	db        14,0,8,0,3,0,0,0,4,0,2,0,97,18,0,0
	db        12,0,1,2,2,0,176,17,0,0,16,0,0,0,14,0
	db        8,0,3,0,0,0,4,0,2,0,99,18,0,0,12,0
	db        1,2,2,0,31,17,0,0,16,0,0,0,14,0,8,0
	db        3,0,0,0,4,0,2,0,101,18,0,0,12,0,1,2
	db        2,0,235,17,0,0,16,0,0,0,14,0,8,0,3,0
	db        0,0,4,0,2,0,103,18,0,0,12,0,1,2,2,0
	db        221,17,0,0,16,0,0,0
$$BTYPES	ends
$$BNAMES	segment byte public use32 'DEBNAM'
	db	6,'TForm1'
	db	16,'@Buttons@TBitBtn'
	db	21,'@Buttons@TButtonStyle'
	db	21,'@Buttons@bsAutoDetect'
	db	16,'@Buttons@bsWin31'
	db	14,'@Buttons@bsNew'
	db	20,'@Buttons@TBitBtnKind'
	db	17,'@Buttons@bkCustom'
	db	13,'@Buttons@bkOK'
	db	17,'@Buttons@bkCancel'
	db	15,'@Buttons@bkHelp'
	db	14,'@Buttons@bkYes'
	db	13,'@Buttons@bkNo'
	db	16,'@Buttons@bkClose'
	db	16,'@Buttons@bkAbort'
	db	16,'@Buttons@bkRetry'
	db	17,'@Buttons@bkIgnore'
	db	14,'@Buttons@bkAll'
	db	22,'@Buttons@TButtonLayout'
	db	20,'@Buttons@blGlyphLeft'
	db	21,'@Buttons@blGlyphRight'
	db	19,'@Buttons@blGlyphTop'
	db	22,'@Buttons@blGlyphBottom'
	db	49,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	52,'@System@%SetBase$20Controls@TAnchorKinduc$i0$uc$i3$%'
	db	4,'Data'
	db	12,'TSetTypeRTTI'
	db	60,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$bctr$qqrv'
	db	111,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$basg$qqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$brplu$qqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$brmin$qqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$brmul$qqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$badd$xqqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$bsub$xqqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$bmul$xqqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	82,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$blsh$qqrx20Controls@TAnchorKind'
	db	82,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$brsh$qqrx20Controls@TAnchorKind'
	db	8,'Contains'
	db	5,'Clear'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$beql$xqqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	112,'@System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%@$bneq$xqqrrx48System@%Set$t20Controls@TAnchorKind$iuc$0$iuc$3%'
	db	28,'@Controls@TControl@GetAction'
	db	28,'@Controls@TControl@SetAction'
	db	29,'@Controls@TControl@SetAnchors'
	db	30,'@Controls@TControl@SetBiDiMode'
	db	26,'@Controls@TControl@GetText'
	db	26,'@Controls@TControl@SetText'
	db	28,'@Stdctrls@TButton@SetDefault'
	db	29,'@Controls@TControl@GetEnabled'
	db	29,'@Controls@TControl@SetEnabled'
	db	25,'@Buttons@TBitBtn@GetGlyph'
	db	25,'@Buttons@TBitBtn@SetGlyph'
	db	24,'@Buttons@TBitBtn@GetKind'
	db	24,'@Buttons@TBitBtn@SetKind'
	db	26,'@Buttons@TBitBtn@SetLayout'
	db	26,'@Buttons@TBitBtn@SetMargin'
	db	29,'@Buttons@TBitBtn@GetNumGlyphs'
	db	29,'@Buttons@TBitBtn@SetNumGlyphs'
	db	36,'@Controls@TControl@SetParentShowHint'
	db	36,'@Controls@TControl@SetParentBiDiMode'
	db	30,'@Controls@TControl@SetShowHint'
	db	25,'@Buttons@TBitBtn@SetStyle'
	db	27,'@Buttons@TBitBtn@SetSpacing'
	db	33,'@Controls@TWinControl@GetTabOrder'
	db	33,'@Controls@TWinControl@SetTabOrder'
	db	32,'@Controls@TWinControl@SetTabStop'
	db	29,'@Controls@TControl@SetVisible'
	db	9,'inherited'
	db	7,'FCanvas'
	db	6,'FGlyph'
	db	6,'FStyle'
	db	5,'FKind'
	db	7,'FLayout'
	db	8,'FSpacing'
	db	7,'FMargin'
	db	9,'IsFocused'
	db	14,'FModifiedGlyph'
	db	8,'DrawItem'
	db	8,'SetGlyph'
	db	8,'GetGlyph'
	db	12,'GetNumGlyphs'
	db	12,'SetNumGlyphs'
	db	12,'GlyphChanged'
	db	8,'IsCustom'
	db	15,'IsCustomCaption'
	db	8,'SetStyle'
	db	7,'SetKind'
	db	7,'GetKind'
	db	9,'SetLayout'
	db	10,'SetSpacing'
	db	9,'SetMargin'
	db	13,'CNMeasureItem'
	db	10,'CNDrawItem'
	db	13,'CMFontChanged'
	db	16,'CMEnabledChanged'
	db	15,'WMLButtonDblClk'
	db	12,'ActionChange'
	db	12,'CreateHandle'
	db	12,'CreateParams'
	db	10,'GetPalette'
	db	14,'SetButtonStyle'
	db	47,'@Buttons@TBitBtn@$bctr$qqrp18Classes@TComponent'
	db	27,'@Buttons@TBitBtn@$bdtr$qqrv'
	db	5,'Click'
	db	6,'Action'
	db	7,'Anchors'
	db	8,'BiDiMode'
	db	6,'Cancel'
	db	7,'Caption'
	db	11,'Constraints'
	db	7,'Default'
	db	7,'Enabled'
	db	5,'Glyph'
	db	4,'Kind'
	db	6,'Layout'
	db	6,'Margin'
	db	11,'ModalResult'
	db	9,'NumGlyphs'
	db	14,'ParentShowHint'
	db	14,'ParentBiDiMode'
	db	8,'ShowHint'
	db	5,'Style'
	db	7,'Spacing'
	db	8,'TabOrder'
	db	7,'TabStop'
	db	7,'Visible'
	db	7,'OnEnter'
	db	6,'OnExit'
	db	42,'@Buttons@TBitBtn@$basg$qr15Buttons@TBitBtn'
	db	6,'Image1'
	db	6,'Panel1'
	db	7,'Desenha'
	db	6,'Figura'
	db	9,'GroupBox1'
	db	6,'Label1'
	db	6,'Label2'
	db	9,'GroupBox2'
	db	6,'Label3'
	db	6,'Label4'
	db	4,'EdX2'
	db	4,'EdY2'
	db	4,'EdX1'
	db	4,'EdY1'
	db	11,'RadioGroup1'
	db	12,'RadioButton1'
	db	12,'RadioButton2'
	db	9,'GroupBox3'
	db	6,'Label5'
	db	4,'EdX3'
	db	9,'Mensagens'
	db	8,'Mensagem'
	db	7,'BitBtn1'
	db	12,'DesenhaClick'
	db	12,'FiguraChange'
	db	12,'BitBtn1Click'
	db	11,'ApagaImagem'
	db	12,'ValidaNumero'
	db	17,'DesenhaRectangulo'
	db	16,'DesenhaTriangulo'
	db	14,'DesenhaLosango'
	db	20,'DesenhaParalelogramo'
	db	15,'DesenhaTrapezio'
	db	16,'DesenhaPentagono'
	db	13,'DesenhaDivisa'
	db	38,'@TForm1@$bctr$qqrp18Classes@TComponent'
	db	23,'@TForm1@$basg$qr6TForm1'
	db	18,'@TForm1@$bdtr$qqrv'
	db	38,'@TForm1@$bctr$qqrp18Classes@TComponent'
	db	4,'this'
	db	5,'Owner'
	db	7,'pCanvas'
	db	20,'@TForm1@BitBtn1Click'
	db	4,'this'
	db	6,'Sender'
	db	3,'rec'
	db	20,'@TForm1@DesenhaClick'
	db	4,'this'
	db	6,'Sender'
	db	6,'status'
	db	20,'@TForm1@FiguraChange'
	db	4,'this'
	db	6,'Sender'
	db	19,'@TForm1@ApagaImagem'
	db	4,'this'
	db	3,'rec'
	db	20,'@TForm1@ValidaNumero'
	db	4,'this'
	db	5,'value'
	db	3,'min'
	db	3,'max'
	db	25,'@TForm1@DesenhaRectangulo'
	db	4,'this'
	db	2,'x1'
	db	2,'y1'
	db	2,'x2'
	db	2,'y2'
	db	7,'pCanvas'
	db	24,'@TForm1@DesenhaTriangulo'
	db	4,'this'
	db	2,'x1'
	db	2,'y1'
	db	2,'x2'
	db	2,'y2'
	db	7,'pCanvas'
	db	22,'@TForm1@DesenhaLosango'
	db	4,'this'
	db	2,'x1'
	db	2,'y1'
	db	2,'x2'
	db	2,'y2'
	db	7,'pCanvas'
	db	28,'@TForm1@DesenhaParalelogramo'
	db	4,'this'
	db	2,'x1'
	db	2,'y1'
	db	2,'x2'
	db	2,'y2'
	db	2,'x3'
	db	7,'pCanvas'
	db	23,'@TForm1@DesenhaTrapezio'
	db	4,'this'
	db	2,'x1'
	db	2,'y1'
	db	2,'x2'
	db	2,'y2'
	db	2,'x3'
	db	7,'pCanvas'
	db	21,'@TForm1@DesenhaDivisa'
	db	4,'this'
	db	2,'x1'
	db	2,'y1'
	db	2,'x2'
	db	2,'y2'
	db	2,'x3'
	db	7,'pCanvas'
	db	43,'@Forms@TForm@$bctr$qqrp18Classes@TComponent'
	db	4,'this'
	db	6,'AOwner'
	db	26,'@Windows@TRect@$bctr$qiiii'
	db	4,'this'
	db	1,'l'
	db	1,'t'
	db	1,'r'
	db	1,'b'
	db	29,'@System@AnsiString@$bctr$qqrv'
	db	4,'this'
	db	25,'@System@AnsiString@Length'
	db	4,'this'
	db	25,'@System@AnsiString@GetRec'
	db	4,'this'
	db	18,'@TForm1@$bdtr$qqrv'
	db	4,'this'
	db	34,'@Classes@TComponent@UpdateRegistry'
	db	4,'this'
	db	8,'Register'
	db	7,'ClassID'
	db	6,'ProgID'
	db	44,'@Forms@TForm@$bctr$qqrp18Classes@TComponenti'
	db	4,'this'
	db	6,'AOwner'
	db	5,'Dummy'
	db	23,'@Forms@TForm@$bdtr$qqrv'
	db	4,'this'
	db	43,'@System@%DelphiInterface$t14Forms@IOleForm%'
	db	4,'intf'
	db	54,'@System@%DelphiInterface$t14Forms@IOleForm%@$bctr$qqrv'
	db	54,'@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv'
	db	98,'@System@%DelphiInterface$t14Forms@IOleForm%@$basg$qqrr42System@%DelphiInterface$t14Forms@IOleForm%'
	db	56,'@System@%DelphiInterface$t14Forms@IOleForm%@$barow$xqqrv'
	db	53,'@System@%DelphiInterface$t14Forms@IOleForm%@$bnot$xqv'
	db	19,'operator IOleForm *'
	db	54,'@System@%DelphiInterface$t14Forms@IOleForm%@$bind$qqrv'
	db	7,'Release'
	db	54,'@System@%DelphiInterface$t14Forms@IOleForm%@$badr$qqrv'
	db	54,'@System@%DelphiInterface$t14Forms@IOleForm%@$bdtr$qqrv'
	db	4,'this'
	db	44,'@System@%DelphiInterface$t15Forms@IDesigner%'
	db	4,'intf'
	db	55,'@System@%DelphiInterface$t15Forms@IDesigner%@$bctr$qqrv'
	db	55,'@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv'
	db	100,'@System@%DelphiInterface$t15Forms@IDesigner%@$basg$qqrr43System@%DelphiInterface$t15Forms@IDesigner%'
	db	57,'@System@%DelphiInterface$t15Forms@IDesigner%@$barow$xqqrv'
	db	54,'@System@%DelphiInterface$t15Forms@IDesigner%@$bnot$xqv'
	db	20,'operator IDesigner *'
	db	55,'@System@%DelphiInterface$t15Forms@IDesigner%@$bind$qqrv'
	db	7,'Release'
	db	55,'@System@%DelphiInterface$t15Forms@IDesigner%@$badr$qqrv'
	db	55,'@System@%DelphiInterface$t15Forms@IDesigner%@$bdtr$qqrv'
	db	4,'this'
	db	50,'@System@%DelphiInterface$t21Controls@IDockManager%'
	db	4,'intf'
	db	61,'@System@%DelphiInterface$t21Controls@IDockManager%@$bctr$qqrv'
	db	61,'@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv'
	db	112,'@System@%DelphiInterface$t21Controls@IDockManager%@$basg$qqrr49System@%DelphiInterface$t21Controls@IDockManager%'
	db	63,'@System@%DelphiInterface$t21Controls@IDockManager%@$barow$xqqrv'
	db	60,'@System@%DelphiInterface$t21Controls@IDockManager%@$bnot$xqv'
	db	23,'operator IDockManager *'
	db	61,'@System@%DelphiInterface$t21Controls@IDockManager%@$bind$qqrv'
	db	7,'Release'
	db	61,'@System@%DelphiInterface$t21Controls@IDockManager%@$badr$qqrv'
	db	61,'@System@%DelphiInterface$t21Controls@IDockManager%@$bdtr$qqrv'
	db	4,'this'
	db	5,'Form1'
	db	3,'std'
	db	6,'System'
	db	19,'@System@varSmallint'
	db	18,'@System@varInteger'
	db	17,'@System@varSingle'
	db	17,'@System@varDouble'
	db	19,'@System@varCurrency'
	db	15,'@System@varDate'
	db	17,'@System@varOleStr'
	db	19,'@System@varDispatch'
	db	18,'@System@varBoolean'
	db	18,'@System@varVariant'
	db	18,'@System@varUnknown'
	db	15,'@System@varByte'
	db	16,'@System@varByRef'
	db	17,'@System@vtInteger'
	db	17,'@System@vtBoolean'
	db	14,'@System@vtChar'
	db	18,'@System@vtExtended'
	db	16,'@System@vtString'
	db	17,'@System@vtPointer'
	db	15,'@System@vtPChar'
	db	16,'@System@vtObject'
	db	15,'@System@vtClass'
	db	18,'@System@vtWideChar'
	db	19,'@System@vtPWideChar'
	db	20,'@System@vtAnsiString'
	db	18,'@System@vtCurrency'
	db	17,'@System@vtVariant'
	db	8,'Sysutils'
	db	7,'Sysinit'
	db	7,'Windows'
	db	8,'Messages'
	db	8,'Sysconst'
	db	7,'Classes'
	db	8,'Graphics'
	db	17,'@Graphics@clBlack'
	db	15,'@Graphics@clRed'
	db	16,'@Graphics@clBlue'
	db	17,'@Graphics@clWhite'
	db	8,'Commctrl'
	db	7,'Imglist'
	db	8,'Actnlist'
	db	3,'Imm'
	db	7,'Contnrs'
	db	5,'Menus'
	db	8,'Multimon'
	db	8,'Controls'
	db	5,'Forms'
	db	7,'Activex'
	db	6,'Urlmon'
	db	7,'Wininet'
	db	6,'Regstr'
	db	8,'Shellapi'
	db	6,'Shlobj'
	db	8,'Stdctrls'
	db	7,'Commdlg'
	db	7,'Dialogs'
	db	8,'Extctrls'
	db	7,'Buttons'
	db	22,'@Buttons@TButtonLayout'
	db	21,'@Buttons@TButtonStyle'
	db	19,'@Buttons@TNumGlyphs'
	db	20,'@Buttons@TBitBtnKind'
	db	16,'@Buttons@TBitBtn'
	db	6,'TForm1'
	db	7,'Buttons'
	db	8,'Extctrls'
	db	7,'Dialogs'
	db	7,'Commdlg'
	db	8,'Stdctrls'
	db	6,'Shlobj'
	db	8,'Shellapi'
	db	6,'Regstr'
	db	7,'Wininet'
	db	6,'Urlmon'
	db	7,'Activex'
	db	5,'Forms'
	db	8,'Controls'
	db	8,'Multimon'
	db	5,'Menus'
	db	7,'Contnrs'
	db	3,'Imm'
	db	8,'Actnlist'
	db	7,'Imglist'
	db	8,'Commctrl'
	db	8,'Graphics'
	db	7,'Classes'
	db	8,'Sysutils'
	db	8,'Sysconst'
	db	8,'Messages'
	db	7,'Windows'
	db	7,'Sysinit'
	db	6,'System'
	db	5,'_rotr'
	db	5,'_rotl'
	db	6,'_crotr'
	db	6,'_lrotr'
	db	6,'_lrotl'
	db	6,'_crotl'
	db	3,'abs'
	db	6,'wctomb'
	db	7,'wcstoul'
	db	8,'wcstombs'
	db	6,'wcstol'
	db	6,'wcstod'
	db	5,'ultoa'
	db	4,'time'
	db	6,'system'
	db	4,'swab'
	db	7,'strtoul'
	db	6,'strtol'
	db	6,'strtod'
	db	5,'srand'
	db	7,'realloc'
	db	4,'rand'
	db	6,'putenv'
	db	6,'perror'
	db	6,'mbtowc'
	db	8,'mbstowcs'
	db	5,'mblen'
	db	13,'_seterrormode'
	db	26,'@std@%max$T1%$qrxT1t1$rxT1'
	db	26,'@std@%min$T1%$qrxT1t1$rxT1'
	db	17,'@std@randomize$qv'
	db	14,'@std@random$qi'
	db	4,'ltoa'
	db	4,'gcvt'
	db	4,'fcvt'
	db	4,'ecvt'
	db	6,'malloc'
	db	4,'ldiv'
	db	4,'labs'
	db	4,'itoa'
	db	6,'getenv'
	db	4,'free'
	db	4,'exit'
	db	3,'div'
	db	6,'calloc'
	db	4,'atol'
	db	4,'atoi'
	db	4,'atof'
	db	6,'atexit'
	db	5,'abort'
	db	6,'_wtold'
	db	5,'_wtol'
	db	5,'_wtoi'
	db	5,'_wtof'
	db	8,'_wsystem'
	db	11,'_wsplitpath'
	db	11,'_wsearchstr'
	db	11,'_wsearchenv'
	db	8,'_wputenv'
	db	8,'_wperror'
	db	10,'_wmakepath'
	db	8,'_wgetenv'
	db	10,'_wfullpath'
	db	8,'_wcstold'
	db	8,'_strtold'
	db	10,'_splitpath'
	db	10,'_searchstr'
	db	10,'_searchenv'
	db	9,'_makepath'
	db	7,'_wtoi64'
	db	8,'_ui64tow'
	db	8,'_ui64toa'
	db	7,'_i64tow'
	db	7,'_i64toa'
	db	7,'_atoi64'
	db	5,'_ltow'
	db	5,'_ltoa'
	db	6,'_lrand'
	db	5,'_itow'
	db	6,'_ultow'
	db	5,'_gcvt'
	db	5,'_fcvt'
	db	9,'_fullpath'
	db	5,'_exit'
	db	6,'_atold'
	db	5,'_ecvt'
	db	7,'__errno'
	db	10,'__doserrno'
	db	5,'qsort'
	db	7,'lsearch'
	db	5,'lfind'
	db	7,'bsearch'
	db	7,'wcsxfrm'
	db	6,'wcstok'
	db	6,'wcsstr'
	db	6,'wcsspn'
	db	7,'wcsrchr'
	db	7,'wcspcpy'
	db	7,'wcspbrk'
	db	7,'wcsncpy'
	db	7,'wcsncmp'
	db	7,'wcsncat'
	db	6,'wcslen'
	db	7,'wcscspn'
	db	6,'wcscpy'
	db	7,'wcscoll'
	db	6,'wcscmp'
	db	6,'wcschr'
	db	6,'wcscat'
	db	6,'strtok'
	db	18,'@std@strstr$qpxct1'
	db	18,'@std@strstr$qpcpxc'
	db	6,'strspn'
	db	19,'@std@strpbrk$qpxct1'
	db	19,'@std@strpbrk$qpcpxc'
	db	8,'strerror'
	db	7,'strcspn'
	db	18,'@std@strrchr$qpxci'
	db	17,'@std@strrchr$qpci'
	db	7,'strncpy'
	db	7,'strncmp'
	db	7,'strncat'
	db	6,'strlen'
	db	6,'strcpy'
	db	6,'strcmp'
	db	17,'@std@strchr$qpxci'
	db	16,'@std@strchr$qpci'
	db	6,'strcat'
	db	6,'strset'
	db	6,'stpcpy'
	db	7,'strnset'
	db	7,'_wcsset'
	db	7,'_wcsrev'
	db	8,'_wcspcpy'
	db	8,'_wcsnset'
	db	10,'_wcsnicoll'
	db	9,'_wcsnicmp'
	db	9,'_wcsncoll'
	db	9,'_wcsicoll'
	db	8,'_wcsicmp'
	db	7,'_wcsdup'
	db	10,'_strnicoll'
	db	9,'_strncoll'
	db	9,'_stricoll'
	db	9,'_strerror'
	db	9,'_lwcsxfrm'
	db	8,'_lwcsupr'
	db	11,'_lwcsnicoll'
	db	10,'_lwcsncoll'
	db	8,'_lwcslwr'
	db	10,'_lwcsicoll'
	db	9,'_lwcscoll'
	db	9,'_lstrxfrm'
	db	11,'_lstrnicoll'
	db	10,'_lstrncoll'
	db	10,'_lstricoll'
	db	9,'_lstrcoll'
	db	6,'strrev'
	db	8,'strnicmp'
	db	7,'stricmp'
	db	6,'strdup'
	db	7,'_stpcpy'
	db	8,'_lstrupr'
	db	8,'_lstrlwr'
	db	12,'_lwsetlocale'
	db	11,'_wsetlocale'
	db	12,'_llocaleconv'
	db	10,'localeconv'
	db	11,'_lsetlocale'
	db	10,'_ltowlower'
	db	10,'_ltowupper'
	db	8,'towupper'
	db	8,'towlower'
	db	9,'_ltoupper'
	db	7,'toupper'
	db	9,'_ltolower'
	db	7,'tolower'
	db	8,'iswascii'
	db	9,'iswxdigit'
	db	8,'iswupper'
	db	8,'iswspace'
	db	8,'iswpunct'
	db	8,'iswprint'
	db	8,'iswlower'
	db	8,'iswgraph'
	db	8,'iswdigit'
	db	8,'iswcntrl'
	db	8,'iswalpha'
	db	8,'iswalnum'
	db	7,'isascii'
	db	8,'isxdigit'
	db	7,'isupper'
	db	7,'isspace'
	db	7,'ispunct'
	db	7,'isprint'
	db	7,'islower'
	db	7,'isgraph'
	db	7,'isdigit'
	db	7,'iscntrl'
	db	7,'isalpha'
	db	7,'isalnum'
	db	6,'memset'
	db	6,'memcpy'
	db	6,'memcmp'
	db	19,'@std@memchr$qpxviui'
	db	18,'@std@memchr$qpviui'
	db	7,'memmove'
	db	7,'memicmp'
	db	7,'memccpy'
	db	8,'_wmemset'
	db	8,'_wmemcpy'
	db	21,'@std@_wmemchr$qpxviui'
	db	20,'@std@_wmemchr$qpviui'
	db	10,'__threadid'
	db	14,'@std@ptrdiff_t'
	db	11,'@std@size_t'
	db	11,'@std@wint_t'
	db	13,'@std@wctype_t'
	db	12,'@std@va_list'
	db	9,'_chartype'
	db	6,'_lower'
	db	6,'_upper'
	db	5,'lconv'
	db	5,'_argc'
	db	5,'_argv'
	db	12,'__mb_cur_max'
	db	16,'_cmdline_escapes'
	db	8,'_environ'
	db	9,'_fileinfo'
	db	6,'_fmode'
	db	8,'_osmajor'
	db	8,'_osminor'
	db	7,'_osmode'
	db	10,'_osversion'
	db	12,'_sys_errlist'
	db	9,'_sys_nerr'
	db	9,'_wenviron'
	db	13,'@std@atexit_t'
	db	10,'@std@div_t'
	db	11,'@std@ldiv_t'
$$BNAMES	ends
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\Buttons.hpp" 10303 10240
	?debug	D "C:\Documents and Settings\Rita\Ambiente de trabalho\trabalho ac sergio\versao2.0\versao2_0.h" 12334 31865
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\extctrls.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\commdlg.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\CommDlg.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\StdCtrls.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\shellapi.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\ShellAPI.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\regstr.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\RegStr.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\wininet.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\WinInet.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\objidl.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\oaidl.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\oleauto.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\ActiveX.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\UrlMon.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\ShlObj.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\dialogs.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\forms.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\multimon.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\MultiMon.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\Contnrs.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\Menus.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\Imm.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\CommCtrl.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\Commctrl.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\ImgList.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\ActnList.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\controls.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\graphics.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\classes.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\SysConst.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysutils.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\messages.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\dde.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\wincrypt.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\wintrust.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\SysInit.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\windows.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\unknwn.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysvari.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysopen.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\search.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\stdlib.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysdyn.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\systvar.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysset.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\syscomp.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\syscurr.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\systdate.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\systobj.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\rpcnsip.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\rpcndr.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\rpcnterr.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\rpcnsi.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\rpcdcep.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\rpcdce.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\rpc.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\wtypes.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\wstring.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysmac.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\dstring.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysclass.H" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\basetyps.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\prsht.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winspool.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\imm.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\mcx.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winsvc.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winnetwk.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winreg.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winver.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\wincon.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winnls.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\tvout.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winuser.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\pshpack1.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\wingdi.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winerror.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winbase.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\pshpack8.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\pshpack2.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\poppack.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\pshpack4.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\_loc.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\locale.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\_str.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\string.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\guiddef.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\basetsd.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\mbctype.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\ctype.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\winnt.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\windef.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\stdarg.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\excpt.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\_null.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\_defs.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\_stddef.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\mem.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\windows.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\sysmac.H" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\system.hpp" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\vcl0.h" 10303 10240
	?debug	D "C:\PROGRAMAS\BORLAND\CBUILDER5\INCLUDE\VCL\VCL.H" 10303 10240
	?debug	D "C:\Documents and Settings\Rita\Ambiente de trabalho\trabalho ac sergio\versao2.0\versao2_0.cpp" 12381 39101
 ?debug  C FB062A633A5C50524F4752417E315C626F726C616E645C434255494C447E315C6C69625C76636C35302E233030DFF41900E0995D30
 ?debug  C FB05062354466F726D
 ?debug  C FB0508232A54496D616765
 ?debug  C FB0508232A5450616E656C
 ?debug  C FB05082354427574746F6E
 ?debug  C FB0509232A5443616E766173
 ?debug  C FB051223746167445241574954454D535452554354
 ?debug  C FB0509232A544269746D6170
 ?debug  C FB0509232A544F626A656374
 ?debug  C FB0510232654574D4D6561737572654974656D
 ?debug  C FB050D232654574D447261774974656D
 ?debug  C FB050A2326544D657373616765
 ?debug  C FB050A232654574D4D6F757365
 ?debug  C FB050F232654437265617465506172616D73
 ?debug  C FB050C232A54436F6D706F6E656E74
 ?debug  C FB050E232A544261736963416374696F6E
 ?debug  C FB050C2354416E63686F724B696E64
 ?debug  C FB050A2354426944694D6F6465
 ?debug  C FB050B23416E7369537472696E67
 ?debug  C FB0512232A5453697A65436F6E73747261696E7473
 ?debug  C FB050B232A54436F6D626F426F78
 ?debug  C FB050B232A5447726F7570426F78
 ?debug  C FB0508232A544C6162656C
 ?debug  C FB0507232A5445646974
 ?debug  C FB050D232A54526164696F47726F7570
 ?debug  C FB050E232A54526164696F427574746F6E
 ?debug  C FB0507232A5452656374
 ?debug  C FB0507232A54466F726D
 ?debug  C FB0506235452656374
 ?debug  C FB050C232A416E7369537472696E67
 ?debug  C FB05122326416E7369537472696E67537472526563
 ?debug  C FB050B2354436F6D706F6E656E74
 ?debug  C FB050A232A494F6C65466F726D
 ?debug  C FB050A2326494F6C65466F726D
 ?debug  C FB050B232A2A494F6C65466F726D
 ?debug  C FB050B232A4944657369676E6572
 ?debug  C FB050B23264944657369676E6572
 ?debug  C FB050C232A2A4944657369676E6572
 ?debug  C FB050E232A49446F636B4D616E61676572
 ?debug  C FB050E232649446F636B4D616E61676572
 ?debug  C FB050F232A2A49446F636B4D616E61676572
 ?debug  C FB05072354436F6C6F72
 ?debug  C FB05072354496D616765
 ?debug  C FB0508235443616E766173
 ?debug  C FB050B235446696C6C5374796C65
 ?debug  C FB05092354436F6E74726F6C
 ?debug  C FB05102354437573746F6D436F6D626F426F78
 ?debug  C FB050723265452656374
 ?debug  C FB050D232A54437573746F6D466F726D
 ?debug  C FB050C2354437573746F6D466F726D
 ?debug  C FB050823544F626A656374
 ?debug  C FB050C232A544D657461436C617373
 ?debug  C FB050C235457696E436F6E74726F6C
 ?debug  C FB050D232A5450657273697374656E74
 ?debug  C FB0508232A5446696C6572
 ?debug  C FB050C235450657273697374656E74
 ?debug  C FB050B23544F7065726174696F6E
 ?debug  C FB0509232A54526561646572
 ?debug  C FB0509232A54577269746572
 ?debug  C FB050723265F47554944
 ?debug  C FB05072354506F696E74
 ?debug  C FB0510232A5444726167496D6167654C697374
 ?debug  C FB050A2354447261674D6F6465
 ?debug  C FB050D232A5457696E436F6E74726F6C
 ?debug  C FB051523545363726F6C6C696E6757696E436F6E74726F6C
 ?debug  C FB050A232A54436F6E74726F6C
 ?debug  C FB050D235457696E646F775374617465
 ?debug  C FB050C2326416E7369537472696E67
	end
