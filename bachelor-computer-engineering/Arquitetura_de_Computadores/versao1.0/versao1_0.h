//---------------------------------------------------------------------------

#ifndef versao1_0H
#define versao1_0H
//---------------------------------------------------------------------------
#include <Classes.hpp>
#include <Controls.hpp>
#include <StdCtrls.hpp>
#include <Forms.hpp>
#include <Buttons.hpp>
#include <ExtCtrls.hpp>
#include <Graphics.hpp>
//---------------------------------------------------------------------------
class TForm1 : public TForm
{
__published:	// IDE-managed Components

   TImage *Image1;
   TPanel *Panel1;
        TBitBtn *Desenha;
        TComboBox *Figura;
        TGroupBox *GroupBox1;
        TLabel *Label1;
        TLabel *Label2;
        TGroupBox *GroupBox2;
        TLabel *Label3;
        TLabel *Label4;
        TEdit *EdX2;
        TEdit *EdY2;
        TEdit *EdX1;
        TEdit *EdY1;
        TRadioGroup *RadioGroup1;
        TRadioButton *RadioButton1;
        TRadioButton *RadioButton2;
        TGroupBox *GroupBox3;
        TLabel *Label5;
        TEdit *EdX3;
        TGroupBox *Mensagens;
        TLabel *Mensagem;
   TBitBtn *BitBtn1;
   void __fastcall DesenhaClick(TObject *Sender);
        void __fastcall FiguraChange(TObject *Sender);
   void __fastcall BitBtn1Click(TObject *Sender);
private:	// User declarations
   void __fastcall ApagaImagem(void);
   bool __fastcall ValidaNumero(int value, int min, int max);

   void __fastcall DesenhaRectangulo(short int x1,short  int y1,short  int x2,short  int y2);
   void __fastcall DesenhaTriangulo(short int x1,short  int y1,short  int x2,short  int y2);
   void __fastcall DesenhaLosango(short int x1,short  int y1,short  int x2,short  int y2);
   void __fastcall DesenhaParalelogramo(short int x1,short  int y1,short  int x2,short  int y2,short int x3);
   void __fastcall DesenhaTrapezio(short int x1,short  int y1,short  int x2,short  int y2,short int x3);
   void __fastcall DesenhaPentagono(short int x1,short  int y1,short  int x2,short  int y2,short int x3);
   void __fastcall DesenhaDivisa(short int x1,short  int y1,short  int x2,short  int y2,short int x3);

public:		// User declarations
   __fastcall TForm1(TComponent* Owner);
};
//---------------------------------------------------------------------------
extern PACKAGE TForm1 *Form1;
//---------------------------------------------------------------------------
#endif
