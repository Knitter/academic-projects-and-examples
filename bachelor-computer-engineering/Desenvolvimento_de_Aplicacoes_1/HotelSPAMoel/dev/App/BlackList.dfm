object BlackListForm: TBlackListForm
  Tag = 1
  Left = 0
  Top = 0
  Caption = 'Lista Negra'
  ClientHeight = 369
  ClientWidth = 480
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
    480
    369)
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 464
    Height = 353
    Anchors = [akLeft, akTop, akRight, akBottom]
    Caption = 'Lista de Clientes Bloqueados'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clNavy
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    Padding.Left = 5
    Padding.Top = 15
    Padding.Right = 5
    Padding.Bottom = 5
    ParentFont = False
    TabOrder = 0
    DesignSize = (
      464
      353)
    object DBGBlacklist: TDBGrid
      Left = 8
      Top = 18
      Width = 448
      Height = 296
      Anchors = [akLeft, akTop, akRight, akBottom]
      DataSource = HotelGestDataModule.DSBlacklist
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clNavy
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      Columns = <
        item
          Expanded = False
          FieldName = 'id'
          Title.Caption = 'N'#250'mero'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'entry_date'
          Title.Caption = 'Data'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'reservation_id'
          Title.Caption = 'N'#250'mero da Reserva'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'ClientName'
          Title.Caption = 'Cliente'
          Visible = True
        end>
    end
    object DBNav: TDBNavigator
      Left = 8
      Top = 320
      Width = 240
      Height = 25
      DataSource = HotelGestDataModule.DSBlacklist
      Anchors = [akLeft, akBottom]
      TabOrder = 1
    end
    object Button2: TButton
      Left = 381
      Top = 320
      Width = 75
      Height = 25
      Anchors = [akRight, akBottom]
      Caption = 'Fechar'
      TabOrder = 2
      OnClick = Button2Click
    end
  end
end
