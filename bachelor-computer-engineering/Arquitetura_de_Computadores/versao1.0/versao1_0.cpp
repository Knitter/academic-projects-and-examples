/************************************************************************
*** TRABALHO PRATICO AC 2003/2004
***
*** Alunos:
***
*** 11438 Ana Rita Gonçalves Faria  Engª Informática
*** 10635 Sérgio Miguel Neves Lopes Engª Informática
***
************************************************************************/
//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "versao1_0.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"

#define XMAX 639
#define YMAX 479
#define RECTANGULO 0
#define TRIANGULO 1
#define LOSANGO 2
#define PARALELOGRAMO 3
#define TRAPESIO 4
#define DIVISA 5

TForm1 *Form1;

//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
   : TForm(Owner)
{
   TCanvas *pCanvas = Image1->Canvas;
   pCanvas->FloodFill(0,0,clWhite,fsSurface);
   Mensagem->Caption = "   **********2\n   *         *\n   *         *\n   *         *\n   1**********";

   Figura->ItemIndex = 0;
   EdX1->Text = "50";
   EdY1->Text = "30";
   EdX2->Text = "500";
   EdY2->Text = "400";
   EdX3->Text = "300";
}
//---------------------------------------------------------------------------
void __fastcall TForm1::BitBtn1Click(TObject *Sender)
{
     TRect *rec = new TRect(0,0,Image1->Width,Image1->Height);
     Image1->Canvas->FillRect(*rec);
     delete rec;
 }
//---------------------------------------------------------------------------
void __fastcall TForm1::DesenhaClick(TObject *Sender)
{
   bool status = false;

   if (EdX1->Text.Length() == 0)
        EdX1->Text = "10";
   if (EdY1->Text.Length() == 0)
        EdY1->Text = "20";
   if (EdX2->Text.Length() == 0)
        EdX2->Text = "100";
   if (EdY2->Text.Length() == 0)
        EdY2->Text = "200";
   if (EdX3->Text.Length() == 0)
        EdX3->Text = "50";
   ApagaImagem();

   switch(Figura->ItemIndex) {
      case RECTANGULO :
         if (ValidaNumero(EdX1->Text.ToInt(), 0, XMAX-1) == false) break;
         if (ValidaNumero(EdY1->Text.ToInt(), 0, YMAX-1) == false) break;
         if (ValidaNumero(EdX2->Text.ToInt(), EdX1->Text.ToInt()+1, XMAX) == false) break;
         if (ValidaNumero(EdY2->Text.ToInt(), EdY1->Text.ToInt()+1, YMAX) == false) break;

         DesenhaRectangulo(EdX1->Text.ToInt(),EdY1->Text.ToInt(),EdX2->Text.ToInt(),EdY2->Text.ToInt());
         Mensagem->Caption = "Figura \nDesenhada";
         status = true;
         break;
      case TRIANGULO :
         if (ValidaNumero(EdX1->Text.ToInt(), 0, XMAX-1) == false) break;
         if (ValidaNumero(EdY1->Text.ToInt(), 0, YMAX-2) == false) break;
         if (ValidaNumero(EdX2->Text.ToInt(), EdX1->Text.ToInt()+1, XMAX) == false) break;
         if (ValidaNumero(EdY2->Text.ToInt(), EdY1->Text.ToInt()+2, YMAX) == false) break;

         DesenhaTriangulo(EdX1->Text.ToInt(),EdY1->Text.ToInt(),EdX2->Text.ToInt(),EdY2->Text.ToInt());
         Mensagem->Caption = "Figura Desenhada";
         status = true;
         break;
      case LOSANGO :
         if (ValidaNumero(EdX1->Text.ToInt(), 0, XMAX-2) == false) break;
         if (ValidaNumero(EdY1->Text.ToInt(), 0, YMAX-2) == false) break;
         if (ValidaNumero(EdX2->Text.ToInt(), EdX1->Text.ToInt()+2, XMAX) == false) break;
         if (ValidaNumero(EdY2->Text.ToInt(), EdY1->Text.ToInt()+2, YMAX) == false) break;

         DesenhaLosango(EdX1->Text.ToInt(),EdY1->Text.ToInt(),EdX2->Text.ToInt(),EdY2->Text.ToInt());
         Mensagem->Caption = "Figura Desenhada";
         status = true;
         break;
      case PARALELOGRAMO :
      	 if (ValidaNumero(EdX1->Text.ToInt(), 0, XMAX-2) == false) break;
      	 if (ValidaNumero(EdY1->Text.ToInt(), 0, YMAX-1) == false) break;
      	 if (ValidaNumero(EdX2->Text.ToInt(), EdX1->Text.ToInt()+2, XMAX) == false) break;
      	 if (ValidaNumero(EdY2->Text.ToInt(), EdY1->Text.ToInt()+1, YMAX) == false) break;
      	 if (ValidaNumero(EdX3->Text.ToInt(), EdX1->Text.ToInt()+1, EdX2->Text.ToInt()-1) == false) break;

         DesenhaParalelogramo(EdX1->Text.ToInt(),EdY1->Text.ToInt(),EdX2->Text.ToInt(),EdY2->Text.ToInt(),EdX3->Text.ToInt());
         Mensagem->Caption = "Figura Desenhada";
         status = true;
         break;
      case TRAPESIO :
      	 if (ValidaNumero(EdX1->Text.ToInt(), 0, XMAX-3) == false) break;
      	 if (ValidaNumero(EdY1->Text.ToInt(), 0, YMAX-1) == false) break;
      	 if (ValidaNumero(EdX2->Text.ToInt(), EdX1->Text.ToInt()+3, XMAX) == false) break;
      	 if (ValidaNumero(EdY2->Text.ToInt(), EdY1->Text.ToInt()+1, YMAX) == false) break;
      	 if (ValidaNumero(EdX3->Text.ToInt(), (EdX2->Text.ToInt()+EdX1->Text.ToInt())/2+1, EdX2->Text.ToInt()-1) == false) break;

         DesenhaTrapezio(EdX1->Text.ToInt(),EdY1->Text.ToInt(),EdX2->Text.ToInt(),EdY2->Text.ToInt(),EdX3->Text.ToInt());
         Mensagem->Caption = "Figura Desenhada";
         status = true;
         break;
      case DIVISA :
         if (ValidaNumero(EdX1->Text.ToInt(), 0, XMAX-2) == false) break;
         if (ValidaNumero(EdY1->Text.ToInt(), 0, YMAX-2) == false) break;
      	 if (ValidaNumero(EdX2->Text.ToInt(), EdX1->Text.ToInt()+2, XMAX) == false) break;
      	 if (ValidaNumero(EdY2->Text.ToInt(), EdY1->Text.ToInt()+2, YMAX) == false) break;
      	 if (ValidaNumero(EdX3->Text.ToInt(), EdX1->Text.ToInt()+1, EdX2->Text.ToInt()-1) == false) break;

         DesenhaDivisa(EdX1->Text.ToInt(),EdY1->Text.ToInt(),EdX2->Text.ToInt(),EdY2->Text.ToInt(),EdX3->Text.ToInt());
         Mensagem->Caption = "Figura Desenhada";
         status = true;
         break;
   }
   if (status == false)
      Mensagem->Caption = "Erro na definição\ndos pontos da figura";

   status = false;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::FiguraChange(TObject *Sender)
{
   switch(Figura->ItemIndex) {
      case RECTANGULO :
         GroupBox3->Visible = false;
         Mensagem->Caption = "   **********2\n   *         *\n   *         *\n   *         *\n   1**********";
         break;
      case TRIANGULO :
         Mensagem->Caption = "      *  2\n     * *  \n    *   * \n   1******";
         GroupBox3->Visible = false;
         break;
      case LOSANGO :
         Mensagem->Caption = "     * 2\n    * * \n   *   *\n    * * \n   1 *  ";
         GroupBox3->Visible = false;
         break;
      case PARALELOGRAMO :
         Mensagem->Caption = "       3*********2\n      *         * \n     *         *  \n    *         *   \n   1**********    ";
         GroupBox3->Visible = true;
         break;
      case TRAPESIO :
         Mensagem->Caption = "       ******3   2\n      *       *   \n     *         *  \n    *           * \n   1**************";
         GroupBox3->Visible = true;
         break;
      case DIVISA :
         Mensagem->Caption = "   **********3 2\n    *         * \n     *         *\n    *         * \n   1**********  ";
         GroupBox3->Visible = true;
         break;
      default:
         Mensagem->Caption = "";
         GroupBox3->Visible = false;
         break;
    }
}
//---------------------------------------------------------------------------
void  __fastcall TForm1::ApagaImagem(void)
{
   if (RadioButton1->Checked == false){
     TRect *rec = new TRect(0,0,Image1->Width,Image1->Height);
     Image1->Canvas->FillRect(*rec);
     delete rec;
   }
}
//---------------------------------------------------------------------------
bool  __fastcall TForm1::ValidaNumero(int value, int min, int max)
{
	if(value < min || value > max)
	   return false;
   else
	   return true;
}

/****************************************************************************
 * Em baixo encontra-se o código para
 * analisar, estudar e modificar.
 ****************************************************************************/

void  __fastcall TForm1::DesenhaRectangulo(short int x1, short int y1, short int x2, short int y2)
{
   TCanvas *pCanvas = Image1->Canvas;
/*** INICIO do código em assembly para desenhar um rectangulo ***************/

// linha horizontal inferior 
   asm {
      mov dx, x1    //dx variavel de controle do ciclo em x
      mov cx, YMAX
      sub cx, y1   //dx valor segundo o eixo dos y
ciclo_rect1:
      push cx // salvaguarda contexto
      push dx // salvaguarda contexto
      // chamar a funcao pCanvas->Pixels[_CX][_DX] = clRed;
      push      clRed                   // cor
      movzx     ecx,cx                  // ecx = coluna
      movzx     edx,dx                  // edx = linha
      mov       eax,dword ptr [ebp-12]  // eax = pcanvas
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx // restaura contexto
      pop cx // restaura contexto

      inc dx
      cmp dx, x2
      jbe ciclo_rect1
   }
// linha horizontal superior
   asm {
      mov dx, x1    //dx variavel de controle do ciclo em x
      mov cx, YMAX
      sub cx, y2   //dx valor segundo o eixo dos y
ciclo_rect2:
      push cx // salvaguarda contexto
      push dx // salvaguarda contexto
      // chamar a funcao pCanvas->Pixels[_CX][_DX] = clRed;
      push      clRed                   // cor
      movzx     ecx,cx                  // ecx = coluna
      movzx     edx,dx                  // edx = linha
      mov       eax,dword ptr [ebp-12]  // eax = pcanvas
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx // restaura contexto
      pop cx // restaura contexto

      inc dx
      cmp dx, x2
      jbe ciclo_rect2
   }
// linha vertical esquerda
   asm {
      mov dx, x1    //dx variavel de controle do ciclo em x
      mov cx, YMAX
      sub cx, y2   //dx valor segundo o eixo dos y
      mov bx, YMAX
      sub bx, y1   //bx limite do ciclo em y
ciclo_rect3:
      push cx // salvaguarda contexto
      push dx // salvaguarda contexto
      // chamar a funcao pCanvas->Pixels[_CX][_DX] = clRed;
      push      clRed                   // cor
      movzx     ecx,cx                  // ecx = coluna
      movzx     edx,dx                  // edx = linha
      mov       eax,dword ptr [ebp-12]  // eax = pcanvas
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx // restaura contexto
      pop cx // restaura contexto

      inc cx
      cmp cx, bx
      jbe ciclo_rect3
   }
// linha vertical direita
   asm {
      mov dx, x2    //dx variavel de controle do ciclo em x
      mov cx, YMAX
      sub cx, y2   //dx valor segundo o eixo dos y
      mov bx, YMAX
      sub bx, y1   //bx limite do ciclo em y
ciclo_rect4:
      push cx // salvaguarda contexto
      push dx // salvaguarda contexto
      // chamar a funcao pCanvas->Pixels[_CX][_DX] = clRed;
      push      clRed                   // cor
      movzx     ecx,cx                  // ecx = coluna
      movzx     edx,dx                  // edx = linha
      mov       eax,dword ptr [ebp-12]  // eax = pcanvas
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx // restaura contexto
      pop cx // restaura contexto

      inc cx
      cmp cx, bx
      jbe ciclo_rect4
   }
/*** FIM do código em assembly para desenhar um rectangulo *****************/
   pCanvas->Pixels[x1][YMAX-y1] = clBlack;
   pCanvas->Pixels[x2][YMAX-y2] = clBlack;
//   pCanvas->Pixels[x3][YMAX-y2] = clBlack;
}

//---------------------------------------------------------------------------

void  __fastcall TForm1::DesenhaTriangulo(short int x1, short int y1, short int x2, short int y2)
{
   TCanvas *pCanvas = Image1->Canvas;
/*** INICIO do código em assembly para desenhar um triangulo  ***************/
   ApagaImagem();
   pCanvas->TextOutA(230,130,"Não Implementado!!!...");
/*** FIM do código em assembly para desenhar um triangulo  *****************/
}

//---------------------------------------------------------------------------

void  __fastcall TForm1::DesenhaLosango(short int x1, short int y1, short int x2, short int y2)
{
   TCanvas *pCanvas = Image1->Canvas;
/*** INICIO do código em assembly para desenhar um losango  ***************/
   ApagaImagem();
   pCanvas->TextOutA(230,150,"Não Implementado!!!...");
/*** FIM do código em assembly para desenhar um losango  *****************/
}

//---------------------------------------------------------------------------

void  __fastcall TForm1::DesenhaParalelogramo(short int x1, short int y1, short int x2, short int y2,short int x3)
{
   TCanvas *pCanvas = Image1->Canvas;
/****** INICIO do código em assembly para desenhar um paralelogramo************/

/***********************Linha Horizontal Inferior******************************/
   asm {
      mov dx,x1                //dx variavel de controle para paragem do ciclo
      mov cx,YMAX
      sub cx,y1		// equivalente a y1
      mov ax,x2
      sub ax,x3
      add ax,x1                 //x4=x1-x3+x2 (calculado) limite do ciclo

   CICLO_RET_HOR1:              //ciclo para desenhar um pixel
      push ax                   //salvaguardar contexto
      push cx
      push dx
      push      clBlue
      movzx     ecx,cx
      movzx     edx,dx
      mov       eax,dword ptr [ebp-12]
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx
      pop cx
      pop ax

      inc dx                   // incrementar x1 ate chegar a x4(ax)
      cmp dx,ax                //criterio de paragem se x1=x4
      jbe CICLO_RET_HOR1
   }
/***********************Linha Horizontal Superior******************************/
   asm {
      mov dx, x3	       //dx variavel de controle para paragem do ciclo
      mov cx, YMAX
      sub cx, y2	       // equivalente a y2
      mov ax,x2
      sub ax,dx
   CICLO_RET_HOR2:             //ciclo para desenhar um pixel
      push cx                  //salvaguardar contexto
      push dx
      push      clBlue
      movzx     ecx,cx
      movzx     edx,dx
      mov       eax,dword ptr [ebp-12]
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx
      pop cx

      inc dx                   //incrementar x3 ate chegar a x2
      cmp dx,x2                //criterio de paragem se x3=x2
      jbe CICLO_RET_HOR2
   }
/***********************Linha Diagonal Esquerda********************************/
  asm {
      p EQU word ptr ss:[ebp-18]
      Y_2 EQU word ptr ss:[ebp-20]
      sub esp,4

      mov ax,YMAX
      sub ax,y2      // ax variavel para a paragem do ciclo dependente de Y
      mov Y_2,ax
      mov cx,YMAX
      sub cx,y1     // linha inferior
      mov bx,x3
      sub bx,x1     //DX=(x3-x1)
      mov ax,y2
      sub ax,y1    //DY=(y2-y1)
      mov dx,x1     // dx variavel para a paragem do ciclo dependente de X

      cmp bx,ax     // verificacao de qual dos ciclos a utilizar [DX<DY]
      jbe DECLIVE_1
      mov p,ax
      add p,ax
      sub p,bx

   CICLO_DIAG_D1:
      push ax
      push cx
      push dx
      push      clBlue
      movzx     ecx,cx
      movzx     edx,dx
      mov       eax,dword ptr [ebp-12]
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx
      pop cx
      pop ax

      cmp p,0
      jle MENOR_1
      add p,ax
      add p,ax
      sub p,bx
      sub p,bx
      inc dx
      dec cx
      jmp FIM_1
      MENOR_1:
      add p,ax
      add p,ax
      inc dx
      FIM_1:
      cmp dx,x3
      jbe CICLO_DIAG_D1
      jmp FINAL_1

      DECLIVE_1:
      add p,bx
      add p,bx
      sub p,ax

   CICLO_DIAG_D2:
      push ax
      push cx
      push dx
      push      clBlue
      movzx     ecx,cx
      movzx     edx,dx
      mov       eax,dword ptr [ebp-12]
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx
      pop cx
      pop ax

      cmp p,0
      jle MENOR_2
      add p,bx
      add p,bx
      sub p,ax
      sub p,ax
      inc dx
      dec cx
      jmp FIM_2
      MENOR_2:
      add p,bx
      add p,bx
      dec cx
      FIM_2:
      cmp cx,Y_2
      ja CICLO_DIAG_D2
      FINAL_1:
      add esp,4
    }
/***********************Linha Diagonal Direita*********************************/
   asm {
      p EQU word ptr ss:[ebp-18]
      Y_2 EQU word ptr ss:[ebp-20]
      sub esp,4
      mov cx,YMAX
      sub cx,y1

      mov ax,y2
      sub ax,y1        //DY=(y2-y1)
      mov dx,x2
      add dx,x1
      sub dx,x3         // ponto nao dado x4=x2-x3+x1
                        // dx variavel para a paragem do ciclo dependente de X
      mov bx,x2
      sub bx,dx         //DX=(x2-x4)
      cmp bx,ax
      jbe DECLIVE_2
      add p,ax
      add p,ax
      sub p,bx

      CICLO_DIAG_D3:

      push ax
      push cx
      push dx
      push      clBlue
      movzx     ecx,cx
      movzx     edx,dx
      mov       eax,dword ptr [ebp-12]
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx
      pop cx
      pop ax

      cmp p,0
      jle MENOR_3
      add p,ax
      add p,ax
      sub p,bx
      sub p,bx
      inc dx
      dec cx
      jmp FIM_3
      MENOR_3:
      add p,ax
      add p,ax
      inc dx
      FIM_3:
      cmp dx,x2
      jbe CICLO_DIAG_D3
      jmp FINAL_2

      DECLIVE_2:
      add p,bx
      add p,bx
      sub p,ax
      CICLO_DIAG_D4:

      push ax
      push cx
      push dx
      push      clBlue
      movzx     ecx,cx
      movzx     edx,dx
      mov       eax,dword ptr [ebp-12]
      call      @@Graphics@TCanvas@SetPixel$qqrii15Graphics@TColor
      pop dx
      pop cx
      pop ax

      cmp p,0
      jle MENOR_4
      add p,bx
      add p,bx
      sub p,ax
      sub p,ax
      inc dx
      dec cx
      jmp FIM_4
      MENOR_4:
      add p,bx
      add p,bx
      dec cx
      FIM_4:
      cmp cx,Y_2
      ja CICLO_DIAG_D4
      FINAL_2:
      add esp,4
    }
/*** FIM do código em assembly para desenhar um paralelogramo******************/
}
//---------------------------------------------------------------------------

void  __fastcall TForm1::DesenhaTrapezio(short int x1, short int y1, short int x2, short int y2,short int x3)
{
   TCanvas *pCanvas = Image1->Canvas;
/*** INICIO do código em assembly para desenhar um trapezio***************/
   ApagaImagem();
   pCanvas->TextOutA(230,190,"Não Implementado!!!...");
/*** FIM do código em assembly para desenhar um trapezio *****************/
}

//---------------------------------------------------------------------------

void  __fastcall TForm1::DesenhaDivisa(short int x1, short int y1, short int x2, short int y2,short int x3)
{
   TCanvas *pCanvas = Image1->Canvas;
/*** INICIO do código em assembly para desenhar uma divisa  ***************/
   ApagaImagem();
   pCanvas->TextOutA(230,210,"Não Implementado!!!...");
/*** FIM do código em assembly para desenhar uma divisa  *****************/
}

//---------------------------------------------------------------------------






