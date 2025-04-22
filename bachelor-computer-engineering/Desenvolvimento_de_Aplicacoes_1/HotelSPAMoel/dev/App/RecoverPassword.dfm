object RecoverPasswordForm: TRecoverPasswordForm
  Left = 0
  Top = 0
  BorderStyle = bsToolWindow
  Caption = 'Recuperar a Palavra-passe'
  ClientHeight = 166
  ClientWidth = 228
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  Position = poOwnerFormCenter
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox2: TGroupBox
    Left = 8
    Top = 8
    Width = 212
    Height = 120
    Caption = 'Nova Palavra-passe de Utilizador'
    Padding.Left = 5
    Padding.Top = 15
    Padding.Right = 5
    Padding.Bottom = 5
    TabOrder = 0
    object Label2: TLabel
      Left = 8
      Top = 21
      Width = 100
      Height = 13
      Caption = 'Nova Palavra-passe:'
    end
    object Label3: TLabel
      Left = 8
      Top = 67
      Width = 115
      Height = 13
      Caption = 'Repita a Palavra-passe:'
    end
    object EDTNewPassword: TEdit
      Left = 8
      Top = 40
      Width = 193
      Height = 21
      PasswordChar = '*'
      TabOrder = 0
    end
    object EDTRepeatPassword: TEdit
      Left = 8
      Top = 86
      Width = 193
      Height = 21
      PasswordChar = '*'
      TabOrder = 1
    end
  end
  object BTNCancel: TButton
    Left = 145
    Top = 134
    Width = 75
    Height = 25
    Caption = 'Cancelar'
    TabOrder = 1
    OnClick = BTNCancelClick
  end
  object BTNRecover: TButton
    Left = 64
    Top = 133
    Width = 75
    Height = 25
    Caption = 'Recuperar'
    TabOrder = 2
    OnClick = BTNRecoverClick
  end
end
