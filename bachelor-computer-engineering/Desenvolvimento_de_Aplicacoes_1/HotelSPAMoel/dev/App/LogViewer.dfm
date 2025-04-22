object LogViewerForm: TLogViewerForm
  Tag = 7
  Left = 0
  Top = 0
  Caption = 'Registo de Ac'#231#245'es'
  ClientHeight = 345
  ClientWidth = 576
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  FormStyle = fsMDIChild
  OldCreateOrder = False
  Visible = True
  OnClose = FormClose
  OnCreate = FormCreate
  DesignSize = (
    576
    345)
  PixelsPerInch = 96
  TextHeight = 13
  object Label3: TLabel
    Left = 8
    Top = 11
    Width = 20
    Height = 13
    Caption = 'Ver:'
  end
  object DBGLog: TDBGrid
    Left = 8
    Top = 35
    Width = 559
    Height = 272
    Anchors = [akLeft, akTop, akRight, akBottom]
    DataSource = HotelGestDataModule.DSLog
    Options = [dgTitles, dgIndicator, dgColumnResize, dgColLines, dgRowLines, dgTabs, dgRowSelect, dgConfirmDelete, dgCancelOnExit]
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
    Columns = <
      item
        Expanded = False
        FieldName = 'log_action'
        Title.Caption = 'Ac'#231#227'o'
        Width = 250
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'action_date'
        Title.Caption = 'Data'
        Width = 95
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'emp_name'
        Title.Caption = 'Empregado'
        Width = 127
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'surname'
        Visible = True
      end>
  end
  object btnClose: TButton
    Left = 493
    Top = 313
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Caption = 'Fechar'
    TabOrder = 1
    OnClick = btnCloseClick
  end
  object btnClearAll: TButton
    Left = 8
    Top = 313
    Width = 134
    Height = 25
    Anchors = [akLeft, akBottom]
    Caption = 'Eliminar Todos os Registos'
    TabOrder = 2
    OnClick = btnClearAllClick
  end
  object DBNav: TDBNavigator
    Left = 207
    Top = 313
    Width = 220
    Height = 25
    DataSource = HotelGestDataModule.DSLog
    VisibleButtons = [nbFirst, nbPrior, nbNext, nbLast]
    Anchors = [akBottom]
    TabOrder = 3
  end
  object CBXLogType: TComboBox
    Left = 34
    Top = 8
    Width = 206
    Height = 21
    ItemHeight = 13
    TabOrder = 4
    OnChange = CBXLogTypeChange
  end
end
