object TaxForm: TTaxForm
  Tag = 12
  Left = 154
  Top = 225
  BorderIcons = [biSystemMenu, biMinimize]
  BorderStyle = bsSingle
  Caption = 'IVA'
  ClientHeight = 276
  ClientWidth = 344
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  FormStyle = fsMDIChild
  OldCreateOrder = False
  Position = poDefault
  Visible = True
  OnClose = FormClose
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object BTNClose: TBitBtn
    Left = 261
    Top = 241
    Width = 75
    Height = 27
    Caption = 'Fechar'
    TabOrder = 0
    OnClick = BTNCloseClick
  end
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 328
    Height = 227
    Caption = 'Valores de IVA'
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
    TabOrder = 1
    object DBGTax: TDBGrid
      Left = 8
      Top = 18
      Width = 312
      Height = 170
      DataSource = HotelGestDataModule.DSTax
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
          FieldName = 'tax_name'
          Title.Caption = 'Nome'
          Width = 150
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'percentage'
          Title.Caption = 'Percentagem'
          Width = 116
          Visible = True
        end>
    end
    object DBNav: TDBNavigator
      Left = 8
      Top = 194
      Width = 225
      Height = 25
      DataSource = HotelGestDataModule.DSTax
      VisibleButtons = [nbFirst, nbPrior, nbNext, nbLast, nbInsert, nbDelete, nbPost, nbCancel, nbRefresh]
      TabOrder = 1
    end
  end
end
