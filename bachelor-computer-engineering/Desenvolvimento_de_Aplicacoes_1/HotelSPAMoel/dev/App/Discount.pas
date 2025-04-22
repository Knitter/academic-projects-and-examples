unit Discount;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Data, StdCtrls, Buttons, DB, ExtCtrls, DBCtrls, Grids, DBGrids;

type
  TDiscountForm = class(TForm)
    GroupBox1: TGroupBox;
    DBGTax: TDBGrid;
    DBNav: TDBNavigator;
    BTNClose: TBitBtn;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
    procedure BTNCloseClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  DiscountForm: TDiscountForm;

implementation

{$R *.dfm}

uses
  MainForm;

procedure TDiscountForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TDiscountForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetDiscount.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TDiscountForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetDiscount.Active := True;
end;

end.
