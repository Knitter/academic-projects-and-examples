object OptionsForm: TOptionsForm
  Left = 0
  Top = 0
  BorderStyle = bsDialog
  Caption = 'OptionsForm'
  ClientHeight = 272
  ClientWidth = 339
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  Position = poOwnerFormCenter
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 320
    Height = 65
    Caption = 'Geral'
    TabOrder = 0
    object chkSaveAppPos: TCheckBox
      Left = 9
      Top = 19
      Width = 193
      Height = 17
      Caption = 'Guardar Posi'#231#227'o da Janela Principal'
      TabOrder = 0
    end
    object chkSaveAppSize: TCheckBox
      Left = 9
      Top = 42
      Width = 157
      Height = 17
      Caption = 'Guardar Dimens'#227'o da Janela'
      TabOrder = 1
    end
  end
  object GroupBox2: TGroupBox
    Left = 8
    Top = 79
    Width = 321
    Height = 153
    Caption = 'Servidor'
    TabOrder = 1
    object Label1: TLabel
      Left = 7
      Top = 21
      Width = 107
      Height = 13
      Caption = 'Endere'#231'o do Servidor:'
    end
    object Label2: TLabel
      Left = 7
      Top = 42
      Width = 123
      Height = 13
      Caption = 'Base de Dados (Schema):'
    end
    object lblUsername: TLabel
      Left = 33
      Top = 95
      Width = 93
      Height = 13
      Caption = 'Nome de Utilizador:'
      Enabled = False
    end
    object lblPassword: TLabel
      Left = 33
      Top = 123
      Width = 72
      Height = 13
      Caption = 'Palavra-passe:'
      Enabled = False
    end
    object edtServer: TEdit
      Left = 132
      Top = 15
      Width = 178
      Height = 21
      TabOrder = 0
    end
    object edtSchema: TEdit
      Left = 132
      Top = 42
      Width = 178
      Height = 21
      TabOrder = 1
    end
    object chkAuthentication: TCheckBox
      Left = 7
      Top = 69
      Width = 171
      Height = 17
      Caption = 'Usar Autentica'#231#227'o Integrada'
      Checked = True
      State = cbChecked
      TabOrder = 2
      OnClick = chkAuthenticationClick
    end
    object edtUsername: TEdit
      Left = 132
      Top = 92
      Width = 178
      Height = 21
      Enabled = False
      TabOrder = 3
    end
    object edtPassword: TEdit
      Left = 132
      Top = 119
      Width = 178
      Height = 21
      Enabled = False
      PasswordChar = '*'
      TabOrder = 4
    end
  end
  object btnCancel: TButton
    Left = 254
    Top = 238
    Width = 75
    Height = 25
    Caption = 'Cancelar'
    TabOrder = 2
    OnClick = btnCancelClick
  end
  object btnSave: TButton
    Left = 173
    Top = 238
    Width = 75
    Height = 25
    Caption = 'Guardar'
    TabOrder = 3
    OnClick = btnSaveClick
  end
end
