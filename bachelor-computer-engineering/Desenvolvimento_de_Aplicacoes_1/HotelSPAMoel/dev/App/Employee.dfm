object EmployeeForm: TEmployeeForm
  Tag = 5
  Left = 0
  Top = 0
  Caption = 'Empregados'
  ClientHeight = 597
  ClientWidth = 608
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
    608
    597)
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox3: TGroupBox
    Left = 8
    Top = 8
    Width = 592
    Height = 581
    Anchors = [akLeft, akTop, akRight, akBottom]
    Caption = 'Empregados'
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
      592
      581)
    object DBGrid1: TDBGrid
      Left = 8
      Top = 18
      Width = 576
      Height = 202
      Anchors = [akLeft, akTop, akRight, akBottom]
      DataSource = HotelGestDataModule.DSEmployee
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
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'surname'
          Title.Caption = 'Apelido'
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'birth_date'
          Title.Caption = 'Nascimento'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'id_number'
          Title.Caption = 'BI'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'registration_number'
          Title.Caption = 'Contribuinte'
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
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'iban'
          Title.Caption = 'IBAN'
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'email'
          Title.Caption = 'E-mail'
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'emp_username'
          Title.Caption = 'Utilizador'
          Width = 50
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'emp_type'
          Title.Caption = 'Tipo'
          Visible = True
        end>
    end
    object DBNavigator1: TDBNavigator
      Left = 8
      Top = 226
      Width = 224
      Height = 25
      DataSource = HotelGestDataModule.DSEmployee
      VisibleButtons = [nbFirst, nbPrior, nbNext, nbLast, nbDelete, nbPost, nbCancel, nbRefresh]
      Anchors = [akLeft, akBottom]
      TabOrder = 1
    end
    object GroupBox1: TGroupBox
      Left = 8
      Top = 257
      Width = 576
      Height = 317
      Anchors = [akLeft, akRight, akBottom]
      Caption = 'Adicionar Empregado'
      Padding.Left = 5
      Padding.Top = 15
      Padding.Right = 5
      Padding.Bottom = 5
      TabOrder = 2
      DesignSize = (
        576
        317)
      object Label1: TLabel
        Left = 8
        Top = 21
        Width = 31
        Height = 13
        Caption = 'Nome:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label2: TLabel
        Left = 8
        Top = 48
        Width = 39
        Height = 13
        Caption = 'Apelido:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label3: TLabel
        Left = 8
        Top = 129
        Width = 63
        Height = 13
        Caption = 'Contribuinte:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label4: TLabel
        Left = 8
        Top = 237
        Width = 32
        Height = 13
        Caption = 'E-Mail:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label5: TLabel
        Left = 8
        Top = 156
        Width = 46
        Height = 13
        Caption = 'Telefone:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label6: TLabel
        Left = 8
        Top = 183
        Width = 48
        Height = 13
        Caption = 'Telem'#243'vel'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label7: TLabel
        Left = 8
        Top = 210
        Width = 28
        Height = 13
        Caption = 'IBAN:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label10: TLabel
        Left = 8
        Top = 75
        Width = 59
        Height = 13
        Caption = 'Nascimento:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object Label11: TLabel
        Left = 8
        Top = 102
        Width = 14
        Height = 13
        Caption = 'BI:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
      end
      object EDTName: TEdit
        Left = 77
        Top = 18
        Width = 181
        Height = 21
        Anchors = [akLeft, akTop, akRight]
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 0
      end
      object EDTSurname: TEdit
        Left = 77
        Top = 45
        Width = 181
        Height = 21
        Anchors = [akLeft, akTop, akRight]
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 1
      end
      object CHKAdmin: TCheckBox
        Left = 77
        Top = 261
        Width = 92
        Height = 17
        Alignment = taLeftJustify
        Anchors = [akLeft, akBottom]
        BiDiMode = bdRightToLeft
        Caption = 'Administrador?'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentBiDiMode = False
        ParentFont = False
        TabOrder = 2
      end
      object EDTMail: TEdit
        Left = 77
        Top = 234
        Width = 491
        Height = 21
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 3
      end
      object BITBTNInsert: TBitBtn
        Left = 485
        Top = 284
        Width = 75
        Height = 25
        Anchors = [akRight, akBottom]
        Caption = 'Inserir'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 4
        OnClick = BITBTNInsertClick
      end
      object GroupBox2: TGroupBox
        Left = 316
        Top = 18
        Width = 252
        Height = 129
        Anchors = [akTop, akRight]
        Caption = 'Dados de Login'
        Padding.Left = 5
        Padding.Top = 15
        Padding.Right = 5
        Padding.Bottom = 5
        TabOrder = 5
        object Label8: TLabel
          Left = 8
          Top = 21
          Width = 48
          Height = 13
          Caption = 'Utilizador:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label9: TLabel
          Left = 8
          Top = 67
          Width = 72
          Height = 13
          Caption = 'Palavra-passe:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object EDTUsername: TEdit
          Left = 8
          Top = 40
          Width = 236
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 0
        end
        object EDTPassword: TEdit
          Left = 8
          Top = 86
          Width = 236
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          PasswordChar = '*'
          TabOrder = 1
        end
      end
      object DTOBirthDate: TDateTimePicker
        Left = 77
        Top = 72
        Width = 181
        Height = 21
        Date = 39328.154828194440000000
        Time = 39328.154828194440000000
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 6
      end
      object EDTID: TEdit
        Left = 77
        Top = 99
        Width = 121
        Height = 21
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 7
      end
      object EDTRegistrationNr: TEdit
        Left = 77
        Top = 126
        Width = 121
        Height = 21
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 8
      end
      object EDTPhone: TEdit
        Left = 77
        Top = 153
        Width = 121
        Height = 21
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 9
      end
      object EDTCellphone: TEdit
        Left = 77
        Top = 180
        Width = 121
        Height = 21
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 10
      end
      object EDTIban: TEdit
        Left = 77
        Top = 207
        Width = 239
        Height = 21
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Tahoma'
        Font.Style = []
        ParentFont = False
        TabOrder = 11
      end
    end
    object BTNResetPassword: TButton
      Left = 441
      Top = 226
      Width = 143
      Height = 25
      Anchors = [akRight, akBottom]
      Caption = 'Recuperar Palavra-passe'
      TabOrder = 3
      OnClick = BTNResetPasswordClick
    end
  end
end
