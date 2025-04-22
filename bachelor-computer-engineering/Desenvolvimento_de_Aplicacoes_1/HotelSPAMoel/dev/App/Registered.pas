unit Registered;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ExtCtrls, StdCtrls, DBCtrls, Grids, DBGrids, Data, DB;

type
  TRegisteredForm = class(TForm)
    GroupBox1: TGroupBox;
    DBGrid1: TDBGrid;
    DBNav: TDBNavigator;
    GroupBox2: TGroupBox;
    Label1: TLabel;
    EDTSearch: TEdit;
    BTNSearch: TButton;
    BTNClose: TButton;
    BTNSeeAll: TButton;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure BTNCloseClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure BTNSearchClick(Sender: TObject);
    procedure BTNSeeAllClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  RegisteredForm: TRegisteredForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TRegisteredForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TRegisteredForm.BTNSearchClick(Sender: TObject);
var
  filter : String;
begin
  if not (EDTSearch.Text = '') then
  begin
    filter := 'first_name LIKE ' + QuotedStr('*' + EDTSearch.Text + '*')
          + ' OR surname LIKE ' + QuotedStr('*' + EDTSearch.Text + '*');
    HotelGestDataModule.ADODataSetRegistered.Filter := filter;
    HotelGestDataModule.ADODataSetRegistered.Filtered := True;
  end;
end;

procedure TRegisteredForm.BTNSeeAllClick(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetRegistered.Filtered := False;
end;

procedure TRegisteredForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetRegistered.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TRegisteredForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetRegistered.Active := True;
end;

end.
