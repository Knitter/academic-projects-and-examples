//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop
USERES("Project_versao2_0.res");
USEFORM("versao2_0.cpp", Form1);
//---------------------------------------------------------------------------
WINAPI WinMain(HINSTANCE, HINSTANCE, LPSTR, int)
{
   try
   {
       Application->Initialize();
       Application->CreateForm(__classid(TForm1), &Form1);
                 Application->Run();
   }
   catch (Exception &exception)
   {
       Application->ShowException(&exception);
   }
   return 0;
}
//---------------------------------------------------------------------------
