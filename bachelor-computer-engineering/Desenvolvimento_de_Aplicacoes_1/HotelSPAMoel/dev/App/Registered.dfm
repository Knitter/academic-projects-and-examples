object RegisteredForm: TRegisteredForm
  Tag = 9
  Left = 0
  Top = 0
  Caption = 'H'#243'spedes'
  ClientHeight = 406
  ClientWidth = 547
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
    547
    406)
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 8
    Top = 88
    Width = 531
    Height = 310
    Anchors = [akLeft, akTop, akRight, akBottom]
    Caption = 'Lista de H'#243'spedes'
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
      531
      310)
    object DBGrid1: TDBGrid
      Left = 8
      Top = 18
      Width = 515
      Height = 253
      Anchors = [akLeft, akTop, akRight, akBottom]
      DataSource = HotelGestDataModule.DSRegistered
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
          FieldName = 'first_name'
          Title.Caption = 'Nome'
          Width = 135
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'surname'
          Title.Caption = 'Apelido'
          Width = 137
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'id_number'
          Title.Caption = 'BI'
          Width = 76
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'phone'
          Title.Caption = 'Telefone'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'cellphone'
          Title.Caption = 'Telem'#243'vel'
          Width = 91
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'email'
          Title.Caption = 'E-mail'
          Width = 100
          Visible = True
        end>
    end
    object DBNav: TDBNavigator
      Left = 8
      Top = 277
      Width = 240
      Height = 25
      DataSource = HotelGestDataModule.DSRegistered
      Anchors = [akLeft, akBottom]
      TabOrder = 1
    end
    object BTNClose: TButton
      Left = 448
      Top = 277
      Width = 75
      Height = 25
      Anchors = [akRight, akBottom]
      Caption = 'Fechar'
      TabOrder = 2
      OnClick = BTNCloseClick
    end
  end
  object GroupBox2: TGroupBox
    Left = 8
    Top = 8
    Width = 531
    Height = 74
    Anchors = [akLeft, akTop, akRight]
    Caption = 'Pesquisa'
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
    object Label1: TLabel
      Left = 8
      Top = 18
      Width = 84
      Height = 13
      Caption = 'Nome ou Apelido:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
    end
    object EDTSearch: TEdit
      Left = 8
      Top = 37
      Width = 202
      Height = 21
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
    end
    object BTNSearch: TButton
      Left = 216
      Top = 35
      Width = 75
      Height = 25
      Caption = 'Procurar'
      TabOrder = 1
      OnClick = BTNSearchClick
    end
    object BTNSeeAll: TButton
      Left = 297
      Top = 35
      Width = 75
      Height = 25
      Caption = 'Ver Todos'
      TabOrder = 2
      OnClick = BTNSeeAllClick
    end
  end
end
