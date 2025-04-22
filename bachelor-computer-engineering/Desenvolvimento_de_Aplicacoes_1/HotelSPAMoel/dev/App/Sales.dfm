object SalesForm: TSalesForm
  Tag = 14
  Left = 0
  Top = 0
  Caption = 'Relat'#243'rio de Vendas'
  ClientHeight = 375
  ClientWidth = 533
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
  DesignSize = (
    533
    375)
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 517
    Height = 328
    Anchors = [akLeft, akTop, akRight, akBottom]
    Caption = 'Vendas'
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
      517
      328)
    object DBGrid1: TDBGrid
      Left = 8
      Top = 18
      Width = 501
      Height = 302
      Anchors = [akLeft, akTop, akRight, akBottom]
      DataSource = HotelGestDataModule.DSSale
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
          FieldName = 'sale_date'
          Title.Caption = 'Data'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'price'
          Title.Caption = 'Pre'#231'o'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'payed'
          Title.Caption = 'Paga'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'ClientName'
          Title.Caption = 'Cliente'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'EmployeeUser'
          Title.Caption = 'Utilizador'
          Visible = True
        end>
    end
  end
  object BTNClose: TButton
    Left = 450
    Top = 342
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Caption = 'Fechar'
    TabOrder = 1
    OnClick = BTNCloseClick
  end
  object DBNav: TDBNavigator
    Left = 8
    Top = 342
    Width = 225
    Height = 25
    DataSource = HotelGestDataModule.DSSale
    VisibleButtons = [nbFirst, nbPrior, nbNext, nbLast, nbDelete, nbEdit, nbPost, nbCancel, nbRefresh]
    Anchors = [akLeft, akBottom]
    TabOrder = 2
  end
end
