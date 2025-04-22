unit LogViewer;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, DBCtrls, ComCtrls, Grids, DBGrids, DB, ADODB, ExtCtrls,
  Data;

type
  TLogViewerForm = class(TForm)
    DBGLog: TDBGrid;
    btnClose: TButton;
    Label3: TLabel;
    btnClearAll: TButton;
    DBNav: TDBNavigator;
    CBXLogType: TComboBox;
    procedure btnCloseClick(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
    procedure btnClearAllClick(Sender: TObject);
    procedure dblcbxLogTypeExit(Sender: TObject);
    procedure CBXLogTypeChange(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  LogViewerForm: TLogViewerForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TLogViewerForm.btnClearAllClick(Sender: TObject);
begin
  HotelGestDataModule.ADOCommandDeleteLog.Execute;
end;

procedure TLogViewerForm.btnCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TLogViewerForm.CBXLogTypeChange(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetLog.Filtered := False;
  case CBXLogType.ItemIndex of
    1:
    begin
      HotelGestDataModule.ADODataSetLog.Filter := 'log_type_id = 0';
      HotelGestDataModule.ADODataSetLog.Filtered := True;
    end;
    2:
    begin
      HotelGestDataModule.ADODataSetLog.Filter := 'log_type_id = 1';
      HotelGestDataModule.ADODataSetLog.Filtered := True;
    end;
    3:
    begin
      HotelGestDataModule.ADODataSetLog.Filter := 'log_type_id = 2';
      HotelGestDataModule.ADODataSetLog.Filtered := True;
    end;
    4:
    begin
      HotelGestDataModule.ADODataSetLog.Filter := 'log_type_id = 3';
      HotelGestDataModule.ADODataSetLog.Filtered := True;
    end;
  end;

end;

procedure TLogViewerForm.dblcbxLogTypeExit(Sender: TObject);
begin
MessageDlg('Tem a certeza que deseja sair?', mtConfirmation, [mbYes], 0)
end;

procedure TLogViewerForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetLog.Active := False;
  HotelGestDataModule.ADODataSetLogType.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TLogViewerForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetLog.Active := True;
  HotelGestDataModule.ADODataSetLogType.Active := True;
  CBXLogType.Items.Clear;
  CBXLogType.Items.Append('-- ver todos --');
  CBXLogType.ItemIndex := 0;
  while not HotelGestDataModule.ADODataSetLogType.Eof do
  begin
    CBXLogType.Items.Append(HotelGestDataModule.ADODataSetLogType['tp_name']);
    HotelGestDataModule.ADODataSetLogType.Next;
  end;
end;

end.                                 
