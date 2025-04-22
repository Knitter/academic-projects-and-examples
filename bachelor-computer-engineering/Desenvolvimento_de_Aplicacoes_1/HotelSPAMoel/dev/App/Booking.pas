unit Booking;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, Grids, DBGrids, Mask, ComCtrls, DBCtrls, Data;

type
  TBookingForm = class(TForm)
    PageControl1: TPageControl;
    TabSheet1: TTabSheet;
    GroupBox2: TGroupBox;
    TabSheet2: TTabSheet;
    GroupBox1: TGroupBox;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label13: TLabel;
    Label14: TLabel;
    Label19: TLabel;
    EDTRegisteredName: TEdit;
    EDTRegisteredSurname: TEdit;
    MSKRegisteredID: TMaskEdit;
    MSKRegisteredPhone: TMaskEdit;
    MSKRegisteredCellphone: TMaskEdit;
    EDTRegisteredMail: TEdit;
    TabSheet3: TTabSheet;
    TabSheet4: TTabSheet;
    RBNew: TRadioButton;
    RBFormerGuest: TRadioButton;
    RBFomerClient: TRadioButton;
    GroupBox4: TGroupBox;
    Label6: TLabel;
    Label7: TLabel;
    Label8: TLabel;
    Label9: TLabel;
    Label10: TLabel;
    UpDown1: TUpDown;
    EDTDays: TEdit;
    DateTimePicker1: TDateTimePicker;
    DateTimePicker2: TDateTimePicker;
    DBLookupComboBox1: TDBLookupComboBox;
    DBLookupComboBox2: TDBLookupComboBox;
    GroupBox3: TGroupBox;
    TabSheet5: TTabSheet;
    BTNPage2Forward: TButton;
    BTNPage2Back: TButton;
    BTNPage1Forward: TButton;
    BTNPage3Forward: TButton;
    BTNPage3Back: TButton;
    BTNPage4Forward: TButton;
    BTNPage4Back: TButton;
    BTNFinish: TButton;
    BTNCancel: TButton;
    BTNPage5Back: TButton;
    RBReservation: TRadioButton;
    GroupBox5: TGroupBox;
    DBGrid1: TDBGrid;
    BTNAddExtra: TButton;
    LSBExtras: TListBox;
    BTNRemoveExtra: TButton;
    Memo1: TMemo;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure BTNFinishClick(Sender: TObject);
    procedure BTNPage5BackClick(Sender: TObject);
    procedure BTNCancelClick(Sender: TObject);
    procedure BTNPage1ForwardClick(Sender: TObject);
    procedure BTNPage2ForwardClick(Sender: TObject);
    procedure BTNPage2BackClick(Sender: TObject);
    procedure BTNPage3ForwardClick(Sender: TObject);
    procedure BTNPage3BackClick(Sender: TObject);
    procedure BTNPage4ForwardClick(Sender: TObject);
    procedure BTNPage4BackClick(Sender: TObject);
    procedure BTNAddExtraClick(Sender: TObject);
    procedure BTNRemoveExtraClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  BookingForm: TBookingForm;

implementation

{$R *.dfm}

uses
  MainForm;

procedure TBookingForm.BTNAddExtraClick(Sender: TObject);
begin
  LSBExtras.AddItem(HotelGestDataModule.ADODataSetExtra.FieldByName('').Value,  HotelGestDataModule.ADODataSetExtra.FieldByName('')) 
end;

procedure TBookingForm.BTNCancelClick(Sender: TObject);
begin
  Close;
end;

procedure TBookingForm.BTNFinishClick(Sender: TObject);
begin
//TODO 1: insrt data
  Close;
end;

procedure TBookingForm.BTNPage1ForwardClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet2;
  //not implemented yet.
  {if RBNew.Checked then
  else
  if RBFormerGuest.Checked then
  else
  if RBFomerClient.Checked then
  else
  if RBReservation.Checked then}
end;

procedure TBookingForm.BTNPage2BackClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet1;
end;

procedure TBookingForm.BTNPage2ForwardClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet3;
end;

procedure TBookingForm.BTNPage3BackClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet2;
end;

procedure TBookingForm.BTNPage3ForwardClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet4;
end;

procedure TBookingForm.BTNPage4BackClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet3;
end;

procedure TBookingForm.BTNPage4ForwardClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet5;
end;

procedure TBookingForm.BTNPage5BackClick(Sender: TObject);
begin
  PageControl1.ActivePage := TabSheet4;
end;

procedure TBookingForm.BTNRemoveExtraClick(Sender: TObject);
begin
  LSBExtras.DeleteSelected;
end;

procedure TBookingForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

end.
